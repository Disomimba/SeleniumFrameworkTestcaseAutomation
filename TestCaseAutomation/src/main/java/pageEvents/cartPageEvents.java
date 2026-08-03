package pageEvents;

import org.testng.Assert;
import base.BaseTest;
import pageObjects.cartPageElements;
import utils.ElementFetch;

public class cartPageEvents extends BaseTest {

    mainPageEvents mainPage = new mainPageEvents();
    ElementFetch ele = new ElementFetch();

    public void subscribe(String email) {
        
        mainPage.verifyPageUrl("home");
 
        mainPage.clickTab("cart");
        logger.info("Navigated to Cart Page");
        logger.info("Scrolled down to the footer");

        assertElementIsDisplayed("//h2[normalize-space()='Subscription']");
        logger.info("Verified text 'SUBSCRIPTION' is visible in the footer");

        logger.info("Subscribing with email: " + email);
        clear(cartPageElements.txtSubscribe);
        sendKeys(cartPageElements.txtSubscribe, email);
        click(cartPageElements.btnSubscribe);
        
        assertElementIsDisplayed("//div[contains(text(), 'You have been successfully subscribed!')]");
        logger.info("Verified success message 'You have been successfully subscribed!' is visible");
    }

    public void removeProductFromCart() {
        mainPage.clickTab("cart");
        logger.info("Removing product from cart");
        click(cartPageElements.btnRemoveProduct);
    }

    public void verifyAddressDetailsMatch(String expectedAddress) {
        logger.info("Verifying delivery and billing addresses match registration address");
        // Check full address container to avoid li class ordering issues
        String deliveryAddress = ele.getXPATHWebElement("//ul[@id='address_delivery']").getText();
        String billingAddress = ele.getXPATHWebElement("//ul[@id='address_invoice']").getText();
        Assert.assertTrue(deliveryAddress.contains(expectedAddress), "Delivery address mismatch! Found: " + deliveryAddress);
        Assert.assertTrue(billingAddress.contains(expectedAddress), "Billing address mismatch! Found: " + billingAddress);
    }

    public void downloadInvoice() {
        logger.info("Downloading Invoice");
        assertElementIsDisplayed(cartPageElements.btnDownloadInvoice);
        click(cartPageElements.btnDownloadInvoice);
    }
    
    public void verifyCartPageLoaded() {
        Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains(cartPageElements.CART_URL_ENDPOINT), "Cart page not loaded after login");
    }

    public void clickViewCartButton() {
        logger.info("Clicking on Checkout Button");
        click(pageObjects.cartPageElements.btnProceedToCheckout);
    }

    public void clickRegisterLoginButton() {
        logger.info("Clicking on Register/Login Button");
        click(cartPageElements.btnRegisterLogin);
    }
    public void clickProceedToCheckout() {
        logger.info("Clicking Proceed to Checkout button");
        click(cartPageElements.btnProceedToCheckout);
    }

    public void enterCommentAndPlaceOrder(String description) {
        logger.info("Entering order description: " + description);
        clear(cartPageElements.txtDescription);
        sendKeys(cartPageElements.txtDescription, description);
        click(cartPageElements.btnPlaceOrder);
    }

    public void enterPaymentDetailsAndSubmit(String name, String cardNumber, String cvc, String expMonth,
            String expYear) {
        logger.info("Entering payment details for card ending in: " + cardNumber.substring(cardNumber.length() - 4));

        clear(cartPageElements.txtNameOnCard);
        sendKeys(cartPageElements.txtNameOnCard, name);

        clear(cartPageElements.txtCardNumber);
        sendKeys(cartPageElements.txtCardNumber, cardNumber);

        clear(cartPageElements.txtCVC);
        sendKeys(cartPageElements.txtCVC, cvc);

        clear(cartPageElements.txtExpiryMonth);
        sendKeys(cartPageElements.txtExpiryMonth, expMonth);

        clear(cartPageElements.txtExpiryYear);
        sendKeys(cartPageElements.txtExpiryYear, expYear);

        logger.info("Submitting order");
        click(cartPageElements.btnSubmitOrder);
    }


}