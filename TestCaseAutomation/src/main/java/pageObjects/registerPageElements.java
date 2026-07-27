package pageObjects;

public interface registerPageElements {

    //Sign-on Tab
    String txtName = "//input[@placeholder='Name']";
    String txtEmail = "//input[@data-qa='signup-email']";
    String btnSignup = "//button[normalize-space()='Signup']";

    //Additional Info
    String rdnMr = "//input[@id='id_gender1']";
    String rdnMrs = "//input[@id='id_gender2']";
    String txtPassword = "//input[@id='password']";
    String txtDays = "//select[@id='days']";
    String txtMonths = "//select[@id='months']";
    String txtYears = "//select[@id='years']";

    String txtNewletter = "//input[@id='newsletter']";
    String txtOffers = "//input[@id='optin']";

    String txtFirstName = "//input[@id='first_name']";
    String txtLastName = "//input[@id='last_name']";
    String txtCompany = "//input[@id='company']";
    String txtAddress = "//input[@id='address1']";
    String txtAddress2 = "//input[@id='address2']";
    String txtCountry = "//select[@id='country']";
    String txtStateProvince = "//input[@id='state']";
    String txtCity = "//input[@id='city']";
    String txtPostalCode = "//input[@id='zipcode']";
    String txtMobileNumber = "//input[@id='mobile_number']";
    String btnCreateAcc = "//button[normalize-space()='Create Account']";
    String btnContinue = "//a[normalize-space()='Continue']";
    

}
