package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.contactPageEvents;
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;
import pageObjects.cartPageElements;
import pageEvents.mainPageEvents;
import pageEvents.productsEventPage;
import pageEvents.cartPageEvents;

public class TestCases extends BaseTest {
    String browser;
    Dictionary<String, String> registerDetails;
    mainPageEvents mainPage = new mainPageEvents();
    registerPageEvents registerPage = new registerPageEvents();
    loginPageEvents loginPage = new loginPageEvents();
    contactPageEvents contactPage = new contactPageEvents();
    productsEventPage products = new productsEventPage();
    cartPageEvents cartPageEvents = new cartPageEvents();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void prepareReport(@Optional("chrome") String browser) {
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) throws TimeoutException {
        initializeBrowser(browser, testMethod);
    }

    @Test(priority = 1)
    public void tc_01_Register() {
        registerDetails = new Hashtable<>();
        int rnd4Digit = generate4Digit();
        registerDetails.put("name", "Test " + rnd4Digit);
        registerDetails.put("email", "test" + rnd4Digit + "@test.com");
        registerDetails.put("password", "pass" + rnd4Digit);
        registerDetails.put("firstName", "Abdul");
        registerDetails.put("lastName", "Malik");
        registerDetails.put("companyName", "Test Company");
        registerDetails.put("address1", "123 Test Way");
        registerDetails.put("address2", "123 Test Way2");
        registerDetails.put("city", "Cavite");
        registerDetails.put("state", "Metro Manila");
        registerDetails.put("postalCode", "4114");
        registerDetails.put("phone", "09121234567");
        registerPage.register(registerDetails);
    }

    @Test(priority = 2)
    public void tc_02_Login() {
        loginPage.login(registerDetails);
        loginPage.deleteAccount(); // Explicitly delete account for TC 02
    }

    @Test(priority = 3)
    public void tc_03_incorrectEmailPass() {
        if (registerDetails == null) {
            tc_01_Register();
        }
        loginPage.reLogin(registerDetails);
    }

    @Test(priority = 4)
    public void tc_04_accountLogout() {
        tc_01_Register();
        // FIXED: Force logout via URL so Google Ad overlays cannot intercept the click
        driver.get(utils.Constants.url + "logout");
        loginPage.logout(registerDetails.get("email"), registerDetails.get("password"));
    }

    @Test(priority = 5)
    public void tc_05_regExistingEmail() {
        if (registerDetails == null) {
            tc_01_Register();
        }
        registerPage.regExistingEmail(registerDetails.get("name"), registerDetails.get("email"));
    }

    @Test(priority = 6)
    public void tc_06_contactForm() {
        contactPage.fillContactForm("Hakdog", "hakdog@gg.com", "Test Message", "Hello! This is Test message from Hakdog");
    }

    @Test(priority = 7)
    public void tc_07_testcases() {
        mainPage.clickTestCaseTab();
    }

    @Test(priority = 8)
    public void tc_08_products() {
        products.clickViewProduct();
    }

    @Test(priority = 9)
    public void tc_09_searchProduct() {
        products.searchProduct("Rose Pink Embroidered Maxi Dress");
    }

    @Test(priority = 10)
    public void tc_10_subscribeEmailHomePage() {
        mainPage.subscribe("hakdog@gg.com");
    }

    @Test(priority = 11)
    public void tc_11_subscribeEmailCartPage() {
        cartPageEvents.subscribe("hakdog@gg.com");
    }

    @Test(priority = 12)
    public void tc_12_addToCart() {
        products.addToCart();
    }

    @Test(priority = 13)
    public void tc_13_quantityIncrease() {
        products.quantityIncrease("4");
    }

    @Test(priority = 14)
    public void tc_14_placeOrderRegWhileCheckout() {
        products.placeOrderRegWhileCheckout();
        tc_01_Register();
        mainPage.clickCartTab();
        products.proceedToCheckout("I need this tomorrow, Deliver it fast.", "Name Test", "12394321", "135", "12", "2025");
    }

    @Test(priority = 15)
    public void tc_15_regToCheckout() {
        tc_01_Register();
        products.regBeforeCheckout();
        products.proceedToCheckout("I need this tomorrow, Deliver it fast.", "Name Test", "12394321", "135", "12", "2025");
    }

    @Test(priority = 16)
    public void tc_16_loginBeforeCheckout() {
        tc_01_Register();
        driver.get(utils.Constants.url + "logout");
        loginPage.login(registerDetails);

        products.addToCart();
        products.proceedToCheckout("Please deliver ASAP.", "Test User", "4100000000000000", "123", "12", "2028");
        loginPage.deleteAccount();
    }

    @Test(priority = 17)
    public void tc_17_removeProductsFromCart() {
        products.addToCart();
        cartPageEvents.removeProductFromCart();
    }

    @Test(priority = 18)
    public void tc_18_viewCategoryProducts() {
        mainPage.navigateCategories();
    }

    @Test(priority = 19)
    public void tc_19_viewBrandProducts() {
        products.navigateBrands();
    }

    @Test(priority = 20)
    public void tc_20_searchProductsAndVerifyCartAfterLogin() {
        products.searchProduct("Dress");
        products.addSearchResultsToCart();
        mainPage.clickCartTab();

        tc_01_Register();
        mainPage.clickCartTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page not loaded after login");
    }

    @Test(priority = 21)
    public void tc_21_addReviewOnProduct() {
        products.submitProductReview("QA Tester", "qa_tester@test.com", "Great quality product, fits perfectly!");
    }

    @Test(priority = 22)
    public void tc_22_addToCartFromRecommendedItems() {
        mainPage.addRecommendedItemToCart();
        click(pageObjects.productsPageElements.btnViewCart);
        Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "Cart page not loaded");
    }

    @Test(priority = 23)
    public void tc_23_verifyAddressDetailsInCheckoutPage() {
        tc_01_Register();
        products.addToCart();
        mainPage.clickCartTab();
        click(cartPageElements.btnProceedToCheckout);

        cartPageEvents.verifyAddressDetailsMatch("123 Test Way");
        click(pageObjects.loginPageElements.btnDelete);
    }

    @Test(priority = 24)
    public void tc_24_downloadInvoiceAfterPurchaseOrder() {
        tc_01_Register();
        products.addToCart();
        mainPage.clickCartTab();
        click(cartPageElements.btnProceedToCheckout);

        clear(cartPageElements.txtDescription);
        sendKeys(cartPageElements.txtDescription, "Order for Invoice Test");
        click(cartPageElements.btnPlaceOrder);
        clear(cartPageElements.txtNameOnCard);
        sendKeys(cartPageElements.txtNameOnCard, "Test Card");
        clear(cartPageElements.txtCardNumber);
        sendKeys(cartPageElements.txtCardNumber, "4100000000000000");
        clear(cartPageElements.txtCVC);
        sendKeys(cartPageElements.txtCVC, "123");
        clear(cartPageElements.txtExpiryMonth);
        sendKeys(cartPageElements.txtExpiryMonth, "01");
        clear(cartPageElements.txtExpiryYear);
        sendKeys(cartPageElements.txtExpiryYear, "2030");
        click(cartPageElements.btnSubmitOrder);

        cartPageEvents.downloadInvoice();
        click(pageObjects.loginPageElements.btnDelete);
    }

    @Test(priority = 25)
    public void tc_25_verifyScrollUpUsingArrowButton() {
        mainPage.verifyScrollUpWithArrow();
    }

    @Test(priority = 26)
    public void tc_26_verifyScrollUpWithoutArrowButton() {
        mainPage.verifyScrollUpWithoutArrow();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        afterMethod(result, browser);
    }
}