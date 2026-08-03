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
    @Parameters({ "browser" })
    // public void prepareReport(@Optional("chrome") String browser) {
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
        mainPage.verifyPageUrl("home");
        registerPage.register(registerDetails);
        loginPage.deleteAccount();
    }

    @Test(priority = 2)
    public void tc_02_Login() {
        registerPage.register(registerDetails);
        loginPage.logout();
        mainPage.clickTab("home");

        loginPage.login(registerDetails);
        loginPage.deleteAccount();
    }

    @Test(priority = 3)
    public void tc_03_incorrectEmailPass() {
        loginPage.wrongEmailPass();
    }

    @Test(priority = 4)
    public void tc_04_accountLogout() {
        loginPage.logout("Async Co", "AutomationOfGroup@Async.co", "passwordAsyncCo");
    }

    @Test(priority = 5)
    public void tc_05_regExistingEmail() {
        registerPage.regExistingEmail("AsyncCo TwoPointOw", "AutomationOfGroup@Async.co");
    }

    @Test(priority = 6)
    public void tc_06_contactForm() {
        contactPage.fillContactForm("Async Co Group", "AutomationOfGroup@Async.co", "AsynCo Pero gusto Uno",
                "Hello! This is Test message from Async Co. Sana Maka uno kaming Group");
    }

    @Test(priority = 7)
    public void tc_07_testcases() {
        mainPage.clickTab("test_cases");
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
        registerPage.register();
        mainPage.clickTab("cart");
        products.proceedToCheckout(
            "I need this tomorrow, Deliver it fast.", 
            "Name Test", 
            "12394321", 
            "135", 
            "12",
            "2025");
        loginPage.deleteAccount();
    }

    @Test(priority = 15)
    public void tc_15_regToCheckout() {
        registerPage.register(registerDetails);
        products.regBeforeCheckout();
        products.proceedToCheckout("I need this tomorrow, Deliver it fast.", "Name Test", "12394321", "135", "12",
                "2025");

        loginPage.deleteAccount();
    }

    @Test(priority = 16)
    public void tc_16_loginBeforeCheckout() {
        registerPage.register();
        loginPage.logout();
        loginPage.login();
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
        mainPage.clickTab("cart");
        loginPage.login("AutomationOfGroup@Async.co", "passwordAsyncCo");
        mainPage.clickTab("cart");
        cartPageEvents.verifyCartPageLoaded();
    }

    @Test(priority = 21)
    public void tc_21_addReviewOnProduct() {
        products.submitProductReview("QA Tester", "qa_tester@test.com", "Great quality product, fits perfectly!");
    }

    @Test(priority = 22)
    public void tc_22_addToCartFromRecommendedItems() {
        mainPage.addRecommendedItemToCart();
        products.clickViewCartButton();
        cartPageEvents.verifyCartPageLoaded();
    }

    @Test(priority = 23)
    public void tc_23_verifyAddressDetailsInCheckoutPage() {
        registerPage.register();
        loginPage.verifyUsername("Async Corp");
        products.addToCart_tc_23();
        cartPageEvents.verifyAddressDetailsMatch("123 Test Way");
        loginPage.clickDeleteButton();
    }

    @Test(priority = 24)
    public void tc_24_downloadInvoiceAfterPurchaseOrder() {
        products.addToCart_tc_23();
        cartPageEvents.clickViewCartButton();
        registerPage.register();
        loginPage.verifyUsername("Async Corp");
        mainPage.clickTab("cart");
        cartPageEvents.clickProceedToCheckout();
        cartPageEvents.verifyAddressDetailsMatch("123 Test Way");
        cartPageEvents.enterCommentAndPlaceOrder("Order for Invoice Test");
        cartPageEvents.enterPaymentDetailsAndSubmit("Test Card", "4100000000000000", "123", "01", "2030");
        cartPageEvents.downloadInvoice();
        loginPage.deleteAccount();
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