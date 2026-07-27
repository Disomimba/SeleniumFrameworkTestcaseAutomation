package pageEvents;

import java.util.Dictionary;

import base.BaseTest;
import pageObjects.registerPageElements;

public class registerPageEvents extends BaseTest{

    mainPageEvents mainPage = new mainPageEvents();

    public void register(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        logger.info("At Dashboard");
        mainPage.clickLoginSignupTab();
        
        //Fill Up new User
        logger.info("Fill Up New User");
        clear(registerPageElements.txtName);
        sendKeys(registerPageElements.txtName, registerDetails.get("name").toString());

        clear(registerPageElements.txtEmail);
        sendKeys(registerPageElements.txtEmail,registerDetails.get("email").toString());

        click(registerPageElements.btnSignup);

        
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
        click(registerPageElements.btnContinue);

    }

    public void regExistingEmail(String name, String email){
        mainPage.clickLoginSignupTab();

        clear(registerPageElements.txtName);
        sendKeys(registerPageElements.txtName, name);

        clear(registerPageElements.txtEmail);
        sendKeys(registerPageElements.txtEmail, email);

        click(registerPageElements.btnSignup);
        logger.info("Email already Exist");

    }

    public void validateUserRegister(@SuppressWarnings("rawtypes") Dictionary registerDetails){
        
        String userNameLocator = "//b[normalize-space()='Note: Your user name is "+registerDetails.get("name")+".']";
        assertElementIsDisplayed(userNameLocator);
    }
    
}
