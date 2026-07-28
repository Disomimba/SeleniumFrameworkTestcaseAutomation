package pageEvents;
import java.util.Dictionary;
import base.BaseTest;
import pageObjects.loginPageElements;

public class loginPageEvents extends BaseTest{

    mainPageEvents mainPage = new mainPageEvents();


    public void login(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        mainPage.clickLoginSignupTab();
        
        //Fill Up Username and Password
        logger.info("Fill up Username and password");
        clear(loginPageElements.txtEmail);
        sendKeys(loginPageElements.txtEmail, registerDetails.get("email").toString());

        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, registerDetails.get("password").toString());

        //Click Submit button
        click(loginPageElements.btnSubmit);
        logger.info("Validate User successfully login");
        click(loginPageElements.btnDelete);
        logger.info("Validate User Deleted");

        // Uncomment to see the Prof of Deletion
        // click(loginPageElements.btnContinue);
        // logger.info("Account Deleted");
    }

    public void reLogin(@SuppressWarnings("rawtypes") Dictionary registerDetails){

        mainPage.clickLoginSignupTab();
        
        logger.info("Fill up Username and password");
        clear(loginPageElements.txtEmail);
        sendKeys(loginPageElements.txtEmail, registerDetails.get("email").toString());

        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, registerDetails.get("password").toString());

        click(loginPageElements.btnSubmit);
        logger.info("Incorrect Email and Password");
    
    }

    public void logout(String email, String password){
        mainPage.clickLoginSignupTab();
        
        logger.info("Fill up Email and password");
        clear(loginPageElements.txtEmail);
        sendKeys(loginPageElements.txtEmail,email);

        clear(loginPageElements.txtPassword);
        sendKeys(loginPageElements.txtPassword, password);

        click(loginPageElements.btnSubmit);
        logger.info("Account Logged In");

        click(loginPageElements.btnLogout);
        logger.info("Account Logged Out ");
    }

}
