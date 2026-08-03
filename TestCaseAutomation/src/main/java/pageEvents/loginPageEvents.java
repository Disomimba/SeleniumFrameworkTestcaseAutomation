package pageEvents;

import java.util.Dictionary;
import base.BaseTest;
import pageObjects.loginPageElements;
import org.testng.Assert;

public class loginPageEvents extends BaseTest {
    mainPageEvents mainPage = new mainPageEvents();

    public void login(){
        mainPage.clickTab("login");
        sendKeys(loginPageElements.txtEmail, "async@gmail.com");
        sendKeys(loginPageElements.txtPassword,"passwordAsyncCo");
        click(loginPageElements.btnSubmit);

    }
    
    public void loginWithCheck() {
        logger.info("Navigating to login page");
        mainPage.clickTab("login");
        logger.info("Filling in default Username and password");
        sendKeys(loginPageElements.txtEmail, "async@gmail.com");
        sendKeys(loginPageElements.txtPassword, "passwordAsyncCo");
        
        logger.info("Clicked login button");
        click(loginPageElements.btnSubmit);

    }
    //Para sa Test case 20 need Mag login
    public void login(String email, String password) {
        mainPage.clickTab("login");
        clear(loginPageElements.txtEmail);
        sendKeys(loginPageElements.txtEmail, email);
        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, password);
        click(loginPageElements.btnSubmit);
    }

    public void login(@SuppressWarnings("rawtypes") Dictionary registerDetails) {

        mainPage.verifyPageUrl("home");
        mainPage.clickTab("login");

        assertElementIsDisplayed("//h2[normalize-space()='Login to your account']");
        logger.info("Verified 'Login to your account' is visible");

        logger.info("Fill up Username and password");
        clear(loginPageElements.txtEmail);
        sendKeys(loginPageElements.txtEmail, registerDetails.get("email").toString());
        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, registerDetails.get("password").toString());

        click(loginPageElements.btnSubmit);    
        
        String name = registerDetails.get("name").toString();
        verifyUsername(name);
    }

    public void verifyUsername(String name){
        
        String loggedInUserXPath = "//b[normalize-space()='" + name + "']";
        assertElementIsDisplayed(loggedInUserXPath);

        logger.info("Verified 'Logged in as " + name + "' is visible");
    }

    public void deleteAccount() {
        click(loginPageElements.btnDelete);

        assertElementIsDisplayed("//b[normalize-space()='Account Deleted!']");
        logger.info("Validate User Deleted");
    }

    public void wrongEmailPass() {

        mainPage.verifyPageUrl("home");
        mainPage.clickTab("login");

        assertElementIsDisplayed("//h2[normalize-space()='Login to your account']");
        logger.info("Verified 'Login to your account' is visible");

        logger.info("Fill up Username and password with incorrect details");
        clear(loginPageElements.txtEmail);

        sendKeys(loginPageElements.txtEmail, "wrongEmail@Async.co");

        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, "wrongPassword");

        click(loginPageElements.btnSubmit);

        assertElementIsDisplayed("//p[normalize-space()='Your email or password is incorrect!']");
        logger.info("Verified error 'Your email or password is incorrect!' is visible");
    }

    public void logout(String name, String email, String password) {

        mainPage.verifyPageUrl("home");
        mainPage.clickTab("login");

        assertElementIsDisplayed("//h2[normalize-space()='Login to your account']");
        logger.info("Verified 'Login to your account' is visible");

        logger.info("Fill up Email and password");
        clear(loginPageElements.txtEmail);
        sendKeys(loginPageElements.txtEmail, email);
        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, password);
        click(loginPageElements.btnSubmit);
        logger.info("Account Logged In");
        String loggedInUserXPath = "//b[normalize-space()='" + name + "']";
        assertElementIsDisplayed(loggedInUserXPath);
        logger.info("Verified 'Logged in as " + name + "' is visible");

        logout();
        logger.info("Account Logged Out");

        mainPage.verifyPageUrl("login");
    }

    

    public void logout() {
    click(loginPageElements.btnLogout);
    }

    public void clickDeleteButton() {
        logger.info("Clicking on Delete Button");
        click(pageObjects.loginPageElements.btnDelete);
    }

}