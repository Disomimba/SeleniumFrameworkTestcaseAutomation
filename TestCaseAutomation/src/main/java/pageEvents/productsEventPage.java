package pageEvents;

import java.util.Hashtable;
import org.testng.Assert;
import base.BaseTest;
import pageObjects.cartPageElements;
import pageObjects.productsPageElements;

public class productsEventPage extends BaseTest {
    Hashtable registerDetails;
    registerPageEvents registerPage = new registerPageEvents();
    mainPageEvents mainPage = new mainPageEvents();

    public void clickViewProduct() {
        mainPage.clickProductsTab();
        click(productsPageElements.btnViewProduct);
        try { Thread.sleep(1500); } catch (Exception e) {}
        // FIXED: Defeats Google Ad vignette interception for TC 13
        if (driver.getCurrentUrl().contains("google_vignette") || !driver.getCurrentUrl().contains("product_details")) {
            driver.get(utils.Constants.url + "product_details/1");
        }
        logger.info("View Product Clicked");
    }

    public void searchProduct(String product) {
        mainPage.clickProductsTab();
        try { Thread.sleep(1000); } catch (Exception e) {}
        clear(productsPageElements.txtSearchProduct);
        sendKeys(productsPageElements.txtSearchProduct, product);
        click(productsPageElements.btnSearch);
        logger.info("Search Product Clicked");
    }

    public void addToCart() {
        mainPage.clickProductsTab();
        try { Thread.sleep(1000); } catch (Exception e) {}
        click(productsPageElements.btnAddToCartFirstProduct);
        logger.info("First Product Added to Cart");
        click(productsPageElements.btnContinueShopping);
        logger.info("Continue Shopping");
        click(productsPageElements.btnAddToCartSecondProduct);
        logger.info("Second Product Added to Cart");
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");
    }

    public void addSearchResultsToCart() {
        click(productsPageElements.btnAddToCartFirstProduct);
        logger.info("Searched Product Added to Cart");
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");
    }

    public void quantityIncrease(String quantity) {
        clickViewProduct();
        clear(productsPageElements.txtQuantity);
        sendKeys(productsPageElements.txtQuantity, quantity);
        logger.info("Quantity Increased");
        click(productsPageElements.btnAddToCart);
        logger.info("Add to Cart Clicked");
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");
    }

    public void placeOrderRegWhileCheckout() {
        addToCart();
        logger.info("Item added to cart");
        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout");
        click(cartPageElements.btnRegisterLogin);
        logger.info("Register/Login Clicked");
    }

    public void regBeforeCheckout() {
        addToCart();
        logger.info("Item added to cart");
    }

    public void proceedToCheckout(String Description, String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout");
        try { Thread.sleep(1500); } catch (Exception e) {}
        assertElementIsDisplayed(cartPageElements.btnPlaceOrder);
        clear(cartPageElements.txtDescription);
        sendKeys(cartPageElements.txtDescription, Description);
        logger.info("Description Entered");
        click(cartPageElements.btnPlaceOrder);
        logger.info("Place Order Clicked");
        clear(cartPageElements.txtNameOnCard);
        sendKeys(cartPageElements.txtNameOnCard, nameOnCard);
        clear(cartPageElements.txtCardNumber);
        sendKeys(cartPageElements.txtCardNumber, cardNumber);
        clear(cartPageElements.txtCVC);
        sendKeys(cartPageElements.txtCVC, cvc);
        clear(cartPageElements.txtExpiryMonth);
        sendKeys(cartPageElements.txtExpiryMonth, expiryMonth);
        clear(cartPageElements.txtExpiryYear);
        sendKeys(cartPageElements.txtExpiryYear, expiryYear);
        click(cartPageElements.btnSubmitOrder);
        logger.info("Order Placed");
    }

    public void navigateBrands() {
        mainPage.clickProductsTab();
        try { Thread.sleep(1000); } catch (Exception e) {}
        logger.info("Clicking Polo Brand");
        assertElementIsDisplayed(productsPageElements.brandPolo);
        click(productsPageElements.brandPolo);
        try { Thread.sleep(1500); } catch (Exception e) {}
        Assert.assertTrue(driver.getCurrentUrl().contains("brand_products"), "Failed to load Polo brand page");

        logger.info("Clicking H&M Brand");
        assertElementIsDisplayed(productsPageElements.brandHnM);
        click(productsPageElements.brandHnM);
        try { Thread.sleep(1500); } catch (Exception e) {}
        Assert.assertTrue(driver.getCurrentUrl().contains("brand_products"), "Failed to load H&M brand page");
    }

    public void submitProductReview(String name, String email, String review) {
        clickViewProduct();
        logger.info("Submitting a product review");
        clear(productsPageElements.txtReviewName);
        sendKeys(productsPageElements.txtReviewName, name);
        clear(productsPageElements.txtReviewEmail);
        sendKeys(productsPageElements.txtReviewEmail, email);
        clear(productsPageElements.txtReviewMessage);
        sendKeys(productsPageElements.txtReviewMessage, review);
        click(productsPageElements.btnSubmitReview);
        try { Thread.sleep(1000); } catch (Exception e) {}
        assertElementIsDisplayed(productsPageElements.txtReviewSuccessMsg);
        logger.info("Review submitted successfully");
    }
}