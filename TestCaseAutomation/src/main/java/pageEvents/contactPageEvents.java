package pageEvents;

import base.BaseTest;
import pageObjects.contactPageElements;
import pageObjects.mainPageElements;

import java.io.File;

public class contactPageEvents extends BaseTest {

    mainPageEvents mainPage = new mainPageEvents();

    public void fillContactForm(String name, String email, String subject, String message) {
        
        mainPage.verifyPageUrl("home");

        mainPage.clickTab("contact");
        
        assertElementIsDisplayed("//h2[normalize-space()='Get In Touch']");
        logger.info("Verified 'GET IN TOUCH' is visible");
        
        clear(contactPageElements.txtName);
        sendKeys(contactPageElements.txtName, name);
        
        clear(contactPageElements.txtEmail);
        sendKeys(contactPageElements.txtEmail, email);
        
        clear(contactPageElements.txtSubject);
        sendKeys(contactPageElements.txtSubject, subject);
        
        clear(contactPageElements.txtMessage);
        sendKeys(contactPageElements.txtMessage, message);
        
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + "testfile.txt";
        
        logger.info("Uploading file from: " + filePath);
        sendKeys(contactPageElements.btnUploadFile, filePath);
        
        click(contactPageElements.btnSubmit);
        logger.info("Message Submitted");

        driver.switchTo().alert().accept();
        logger.info("Accepted the browser alert popup");
        
        assertElementIsDisplayed("//div[contains(text(), 'Success! Your details have been submitted successfully.')]");
        logger.info("Verified success message is visible");
        
        click(mainPageElements.btnHome);
        mainPage.verifyPageUrl("home");
    }
}