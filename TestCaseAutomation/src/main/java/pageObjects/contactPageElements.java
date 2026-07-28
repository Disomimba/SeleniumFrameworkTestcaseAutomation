package pageObjects;

public interface contactPageElements {

    String txtName = "//input[@placeholder='Name']";
    String txtEmail = "//input[@placeholder='Email']";
    String txtSubject = "//input[@placeholder='Subject']";
    String txtMessage = "//textarea[@id='message']";
    String btnUploadFile = "//input[@name='upload_file']";
    String btnSubmit = "//input[@name='submit']";
    String btnHome = "//span[normalize-space()='Home']";

    
}
