package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.apache.hc.core5.util.Timeout;
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


public class TestCases extends BaseTest{
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
    public void prepareReport(@Optional("chrome")String browser){
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) throws TimeoutException{
        initializeBrowser(browser, testMethod);
    }



    @Test(priority = 1)
    public void tc_01_Register(){
        registerDetails = new Hashtable<>();
        int rnd4Digit = generate4Digit();
        registerDetails.put("name", "Test "+rnd4Digit);
        registerDetails.put("email", "test"+rnd4Digit+"@test.com");
        registerDetails.put("password", "pass"+rnd4Digit);
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
    public void tc_02_Login(){
        loginPage.login(registerDetails);
    }

    
    @Test(priority = 3)
    public void tc_03_incorrectEmailPass(){
        loginPage.reLogin(registerDetails);
    }

    @Test(priority = 4)
    public void tc_04_accountLogout(){
        loginPage.logout("hakdog@gg.com", "123hakdog");
    }

    @Test(priority = 5)
    public void tc_05_regExistingEmail(){
        registerPage.regExistingEmail("Hakdog", "hakdog@gg.com");
    }

    @Test(priority = 6)
    public void tc_06_contactForm(){
        contactPage.fillContactForm("Hakdog", "hakdog@gg.com", "Test Message", "Hello! This is Test message from Hakdog");
    }
    
    @Test(priority = 7)
    public void tc_07_testcases(){
        mainPage.clickTestCaseTab();
    }

    @Test(priority = 8)
    public void tc_08_products(){
        products.clickViewProduct();
    }

    @Test(priority = 9)
    public void tc_09_searchProduct(){
        products.searchProduct("Rose Pink Embroidered Maxi Dress");
    }

    @Test(priority = 10)
    public void tc_10_subscribeEmailHomePage(){
        mainPage.subscribe("hakdog@gg.com");
    }
    @Test(priority = 11)
    public void tc_10_subscribeEmailCartPage(){
        cartPageEvents.subscribe("hakdog@gg.com");
    }

    @Test(priority = 12)
    public void tc_12_addToCart(){
        products.addToCart();
    }

    @Test(priority = 13)
    public void tc_13_quantityIncrease(){
        products.quantityIncrease("4");
    }

    @Test(priority = 14)
    public void tc_14_placeOrderRegWhileCheckout(){

        products.placeOrderRegWhileCheckout();
        tc_01_Register();
        mainPage.clickCartTab();
        products.proceedToCheckout("I need this tomorrow, Deliver it fast.","Name Test", "12394321", "135", "12", "2025");
    
    }
    
    @Test(priority = 15)
    public void tc_15_regToCheckout(){
        tc_01_Register();
        products.regBeforeCheckout();
        products.proceedToCheckout("I need this tomorrow, Deliver it fast.","Name Test", "12394321", "135", "12", "2025");
    }
    

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        afterMethod(result, browser);
    }



}