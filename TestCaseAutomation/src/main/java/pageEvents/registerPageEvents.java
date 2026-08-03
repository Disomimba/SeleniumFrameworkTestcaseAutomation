package pageEvents;

import java.util.Dictionary;
import org.testng.Assert;
import base.BaseTest;
import pageObjects.registerPageElements;

public class registerPageEvents extends BaseTest{

    mainPageEvents mainPage = new mainPageEvents();

    public void register(){
        mainPage.clickTab("login");

        sendKeys(registerPageElements.txtName, "Async Corp");
        sendKeys(registerPageElements.txtEmail, "async@gmail.com");
        click(registerPageElements.btnSignup);
        if(generateRandomGender() == 1){
            click(registerPageElements.rdnMr);
        }else{
            click(registerPageElements.rdnMrs);
        }
        sendKeys(registerPageElements.txtPassword, "passwordAsyncCo");
        sendKeys(registerPageElements.txtDays, "1");
        sendKeys(registerPageElements.txtMonths, "1");
        sendKeys(registerPageElements.txtYears, "1999");

        click(registerPageElements.txtNewletter);
        click(registerPageElements.txtOffers);

        sendKeys(registerPageElements.txtFirstName,"Async");
        sendKeys(registerPageElements.txtLastName,"Co");
        sendKeys(registerPageElements.txtCompany,"Async Company");
        sendKeys(registerPageElements.txtAddress,"123 Test Way");
        sendKeys(registerPageElements.txtAddress2,"123 Test Way2");
        sendKeys(registerPageElements.txtCountry,"1");
        sendKeys(registerPageElements.txtStateProvince,"Metro Manila");
        sendKeys(registerPageElements.txtCity,"Cavite");
        sendKeys(registerPageElements.txtPostalCode,"4113");
        sendKeys(registerPageElements.txtMobileNumber,"09121234567");
        click(registerPageElements.btnCreateAcc);
        
        click(registerPageElements.btnContinue);

    }
    public void register(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        
        mainPage.clickTab("login");
        
        assertElementIsDisplayed("//h2[normalize-space()='New User Signup!']");
        logger.info("Verified 'New User Signup!' is visible");
        
        logger.info("Fill Up New User Signup!");
        clear(registerPageElements.txtName);
        sendKeys(registerPageElements.txtName, registerDetails.get("name").toString());

        clear(registerPageElements.txtEmail);
        sendKeys(registerPageElements.txtEmail,registerDetails.get("email").toString());

        click(registerPageElements.btnSignup);
        
        assertElementIsDisplayed("//b[normalize-space()='Enter Account Information']");
        logger.info("Verified 'ENTER ACCOUNT INFORMATION' is visible");

        if(generateRandomGender() == 1){
            click(registerPageElements.rdnMr);
        }else{
            click(registerPageElements.rdnMrs);
        }

        clear(registerPageElements.txtPassword);
        sendKeys(registerPageElements.txtPassword,registerDetails.get("password").toString());

        clear(registerPageElements.txtDays);
        sendKeys(registerPageElements.txtDays, Integer.toString(generateDay()));

        clear(registerPageElements.txtMonths);
        sendKeys(registerPageElements.txtMonths, Integer.toString(generateMonth()));

        clear(registerPageElements.txtYears);
        sendKeys(registerPageElements.txtYears, Integer.toString(generateYear()));

        click(registerPageElements.txtNewletter);
        click(registerPageElements.txtOffers);

        clear(registerPageElements.txtFirstName);
        sendKeys(registerPageElements.txtFirstName, registerDetails.get("firstName").toString());

        clear(registerPageElements.txtLastName);
        sendKeys(registerPageElements.txtLastName, registerDetails.get("lastName").toString());
        
        clear(registerPageElements.txtCompany);
        sendKeys(registerPageElements.txtCompany, registerDetails.get("companyName").toString());
        
        clear(registerPageElements.txtAddress);
        sendKeys(registerPageElements.txtAddress, registerDetails.get("address1").toString());

        clear(registerPageElements.txtAddress2);
        sendKeys(registerPageElements.txtAddress2, registerDetails.get("address2").toString());

        clear(registerPageElements.txtCountry);
        sendKeys(registerPageElements.txtCountry, Integer.toString(generateCountry()));

        clear(registerPageElements.txtStateProvince);
        sendKeys(registerPageElements.txtStateProvince, registerDetails.get("state").toString());

        clear(registerPageElements.txtCity);
        sendKeys(registerPageElements.txtCity, registerDetails.get("city").toString());

        clear(registerPageElements.txtPostalCode);
        sendKeys(registerPageElements.txtPostalCode, registerDetails.get("postalCode").toString());

        clear(registerPageElements.txtMobileNumber);
        sendKeys(registerPageElements.txtMobileNumber, registerDetails.get("phone").toString());

        click(registerPageElements.btnCreateAcc);

        assertElementIsDisplayed("//b[normalize-space()='Account Created!']");
        logger.info("Verified 'ACCOUNT CREATED!' is visible");

        click(registerPageElements.btnContinue);
        
        String loggedInUserXPath = "//a[normalize-space()='Logged in as " + registerDetails.get("name").toString() + "']";
        assertElementIsDisplayed(loggedInUserXPath);
        logger.info("Verified 'Logged in as " + registerDetails.get("name").toString() + "' is visible");
    }

    public void regExistingEmail(String name, String email){
        mainPage.verifyPageUrl("home");

        mainPage.clickTab("login");
        
        assertElementIsDisplayed("//h2[normalize-space()='New User Signup!']");
        logger.info("Verified 'New User Signup!' is visible");

        logger.info("Entering existing account details: " + name + " / " + email);
        clear(registerPageElements.txtName);
        sendKeys(registerPageElements.txtName, name);

        clear(registerPageElements.txtEmail);
        sendKeys(registerPageElements.txtEmail, email);

        click(registerPageElements.btnSignup);
        
        assertElementIsDisplayed("//p[normalize-space()='Email Address already exist!']");
        logger.info("Verified error 'Email Address already exist!' is visible");
    }

    public void validateUserRegister(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        
        String userNameLocator = "//b[normalize-space()='Note: Your user name is "+registerDetails.get("name")+".']";
        assertElementIsDisplayed(userNameLocator);
    }
    
}
