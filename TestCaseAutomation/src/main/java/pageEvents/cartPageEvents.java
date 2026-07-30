package pageEvents;

import org.testng.Assert;
import base.BaseTest;
import pageObjects.cartPageElements;
import utils.ElementFetch;

public class cartPageEvents extends BaseTest {

    mainPageEvents mainPage = new mainPageEvents();
    ElementFetch ele = new ElementFetch();

    public void subscribe(String email) {
        mainPage.clickCartTab();
        clear(cartPageElements.txtSubscribe);
        sendKeys(cartPageElements.txtSubscribe, email);

        click(cartPageElements.btnSubscribe);
        logger.info("Subscribed");
    }

    public void removeProductFromCart() {
        mainPage.clickCartTab();
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
}