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
import pageEvents.loginPageEvents;
import pageEvents.registerPageEvents;
import pageEvents.mainPageEvents;


public class TestCases extends BaseTest{
    String browser;
    Dictionary<String, String> registerDetails;
    mainPageEvents mainPage = new mainPageEvents();
    registerPageEvents registerPage = new registerPageEvents();
    loginPageEvents loginPage = new loginPageEvents();
    
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


    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        afterMethod(result, browser);
    }



}