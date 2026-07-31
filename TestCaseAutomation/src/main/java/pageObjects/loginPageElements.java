package pageObjects;

public interface loginPageElements {
    // Sign-on Tab
    String txtEmail = "//input[@data-qa='login-email']";
    String txtPassword = "//input[@placeholder='Password']";
    String btnSubmit = "//button[normalize-space()='Login']";
    
    // Robust href matching for navbar actions
    String btnDelete = "//a[@href='/delete_account']";
    String btnContinue = "//a[@data-qa='continue-button' or contains(text(),'Continue')]";
    String btnLogout = "//a[@href='/logout']";
}