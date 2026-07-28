package pageObjects;


public interface cartPageElements {
    String txtSubscribe = "//input[@id='susbscribe_email']";
    String btnSubscribe = "//button[@id='subscribe']";
    String btnProceedToCheckout = "//a[normalize-space()='Proceed To Checkout']";
    String btnRegisterLogin = "//u[normalize-space()='Register / Login']";
    String txtDescription = "//textarea[@name='message']";
    String btnPlaceOrder = "//a[normalize-space()='Place Order']";
    String txtNameOnCard = "//input[@name='name_on_card']";
    String txtCardNumber = "//input[@name='card_number']";
    String txtCVC = "//input[@placeholder='ex. 311']";
    String txtExpiryMonth = "//input[@placeholder='MM']";
    String txtExpiryYear = "//input[@placeholder='YYYY']";
    String btnSubmitOrder = "//button[@id='submit']";
}
