package pageObjects;

public interface cartPageElements {
    String txtSubscribe = "//input[@id='susbscribe_email']";
    String btnSubscribe = "//button[@id='subscribe']";
    
    // Robust selector using class and text matching
    String btnProceedToCheckout = "//a[contains(text(),'Proceed To Checkout') or contains(@class,'check_out')]";
    
    String btnRegisterLogin = "//u[normalize-space()='Register / Login']";
    String txtDescription = "//textarea[@name='message']";
    String btnPlaceOrder = "//a[normalize-space()='Place Order'] | //button[normalize-space()='Place Order']";
    String txtNameOnCard = "//input[@name='name_on_card']";
    String txtCardNumber = "//input[@name='card_number']";
    String txtCVC = "//input[@placeholder='ex. 311']";
    String txtExpiryMonth = "//input[@placeholder='MM']";
    String txtExpiryYear = "//input[@placeholder='YYYY']";
    String btnSubmitOrder = "//button[@id='submit']";
    
    // Cart Actions
    String btnRemoveProduct = "//a[@class='cart_quantity_delete'][1]";
    String btnDownloadInvoice = "//a[normalize-space()='Download Invoice']";
    String txtDeliveryAddress = "//ul[@id='address_delivery']//li[contains(@class,'address_address1')]";
    String txtBillingAddress = "//ul[@id='address_invoice']//li[contains(@class,'address_address1')]";

    String CART_URL_ENDPOINT = "view_cart";
}