package pageObjects;

public interface loginPageElements {
    
    //Sign-on Tab
    String txtEmail = "//input[@data-qa='login-email']";
    String txtPassword = "//input[@placeholder='Password']";
    String btnSubmit = "//button[normalize-space()='Login']";
    String btnDelete = "//a[normalize-space()='Delete Account']";
    String btnContinue = "//a[normalize-space()='Continue']";
    String btnLogout = "//a[normalize-space()='Logout']";

}
