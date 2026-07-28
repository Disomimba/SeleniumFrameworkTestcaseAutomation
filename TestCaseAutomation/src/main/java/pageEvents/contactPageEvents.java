package pageEvents;

import base.BaseTest;
import pageObjects.contactPageElements;
import java.io.File;

public class contactPageEvents extends BaseTest {

    mainPageEvents mainPage = new mainPageEvents();

    public void fillContactForm(String name, String email, String subject, String message) {
        mainPage.clickContactUs();
        
        // 1. Fill out the standard text fields
        clear(contactPageElements.txtName);
        sendKeys(contactPageElements.txtName, name);
        
        clear(contactPageElements.txtEmail);
        sendKeys(contactPageElements.txtEmail, email);
        
        clear(contactPageElements.txtSubject);
        sendKeys(contactPageElements.txtSubject, subject);
        
        clear(contactPageElements.txtMessage);
        sendKeys(contactPageElements.txtMessage, message);
        
        // 2. Construct the dynamic path to your test file
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + File.separator + "testfile.txt";
        
        // 3. Send the file path directly to the upload input element
        logger.info("Uploading file from: " + filePath);
        sendKeys(contactPageElements.btnUploadFile, filePath);
        
        // 4. Click Submit
        click(contactPageElements.btnSubmit);
        logger.info("Message Submitted");

        //For Screenshot  since it has ano Alert() kapag nag susubmit, hindi inaallow ni System mag screenshot
        driver.switchTo().alert().accept();
    }
}