package pageEvents;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import base.BaseTest;
import pageObjects.cartPageElements;
import pageObjects.mainPageElements;
import pageObjects.productsPageElements;

public class productsEventPage extends BaseTest {
    Hashtable registerDetails;
    registerPageEvents registerPage = new registerPageEvents();
    mainPageEvents mainPage = new mainPageEvents();

    public void clickViewProduct() {
        
        mainPage.verifyPageUrl("home");

        mainPage.clickTab("products");
        mainPage.verifyPageUrl("products");

        assertElementIsDisplayed("//div[@class='features_items']");
        logger.info("Verified the ALL PRODUCTS list is visible");

        click(productsPageElements.btnViewProduct);
        logger.info("View Product Clicked for the first product");
        
        mainPage.verifyPageUrl("product_details");

        logger.info("Verifying all product details are visible on the page...");
        
        assertElementIsDisplayed("//div[@class='product-information']/h2");
        
        assertElementIsDisplayed("//div[@class='product-information']/p[contains(text(),'Category')]");
        
        assertElementIsDisplayed("//div[@class='product-information']/span/span");
        
        assertElementIsDisplayed("//b[normalize-space()='Availability:']");
        
        assertElementIsDisplayed("//b[normalize-space()='Condition:']");
        
        assertElementIsDisplayed("//b[normalize-space()='Brand:']");
        
        logger.info("Successfully verified product name, category, price, availability, condition, and brand are visible");
    }

public void searchProduct(String product) {
        
        mainPage.verifyPageUrl("home");

        mainPage.clickTab("products");
        
        mainPage.verifyPageUrl("products");

        logger.info("Searching for product: " + product);
        clear(productsPageElements.txtSearchProduct);
        sendKeys(productsPageElements.txtSearchProduct, product);
        click(productsPageElements.btnSearch);
        logger.info("Search Product Clicked");
        
        assertElementIsDisplayed("//h2[normalize-space()='Searched Products']");
        logger.info("Verified 'SEARCHED PRODUCTS' header is visible");
        
        String searchResultXPath = "//div[@class='productinfo text-center']//p[contains(text(), '" + product + "')]";
        assertElementIsDisplayed(searchResultXPath);
        logger.info("Verified products related to '" + product + "' are correctly displayed on screen");
    }

    public void addToCart() {

        mainPage.clickTab("products");
        logger.info("Navigated to Products Page");

        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);

        click(productsPageElements.btnAddToCartFirstProduct);
        logger.info("First Product Added to Cart");
        
        click(productsPageElements.btnContinueShopping);
        logger.info("Continue Shopping Clicked");
        
        action.moveToElement(driver.findElement(By.xpath("(//div[@class='productinfo text-center'])[2]"))).perform();
        click(productsPageElements.btnAddToCartSecondProduct);
        logger.info("Second Product Added to Cart");
        
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");

        assertElementIsDisplayed("//tr[@id='product-1']");
        assertElementIsDisplayed("//tr[@id='product-2']");
        logger.info("Verified both Product 1 and Product 2 are visible in the Cart");

        logger.info("Verifying price, quantity, and total price columns for both products...");
        
        // Verifying Product 1 Details
        assertElementIsDisplayed("//tr[@id='product-1']//td[@class='cart_price']");
        assertElementIsDisplayed("//tr[@id='product-1']//button[@class='disabled']"); // Quantity box
        assertElementIsDisplayed("//tr[@id='product-1']//p[@class='cart_total_price']");
        
        // Verifying Product 2 Details
        assertElementIsDisplayed("//tr[@id='product-2']//td[@class='cart_price']");
        assertElementIsDisplayed("//tr[@id='product-2']//button[@class='disabled']"); // Quantity box
        assertElementIsDisplayed("//tr[@id='product-2']//p[@class='cart_total_price']");
        
        logger.info("Successfully verified prices, quantities, and totals for both items.");
    }

    public void addToCart_tc_23() {
        mainPage.verifyPageUrl("home");

        mainPage.clickTab("products");
        logger.info("Navigated to Products Page");

        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(driver);

        click(productsPageElements.btnAddToCartFirstProduct);
        logger.info("First Product Added to Cart");
        
        click(productsPageElements.btnContinueShopping);
        logger.info("Continue Shopping Clicked");
        
        click(productsPageElements.btnAddToCartSecondProduct);
        logger.info("Second Product Added to Cart");
        
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");

        mainPage.verifyPageUrl("cart");

        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout Clicked");
    }


    public void addSearchResultsToCart() {
        click(productsPageElements.btnAddToCartFirstProduct);
        logger.info("Searched Product Added to Cart");
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");
    }

    public void quantityIncrease(String quantity) {
        
        mainPage.verifyPageUrl("home");

        click(mainPageElements.btnViewProduct);
        logger.info("Clicked View Product from Home Page");

        mainPage.verifyPageUrl("product_details");
        
        clear(productsPageElements.txtQuantity);
        sendKeys(productsPageElements.txtQuantity, quantity);
        logger.info("Quantity Increased to: " + quantity);
        
        click(productsPageElements.btnAddToCart);
        logger.info("Add to Cart Clicked");
        
        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");
        
        String quantityXPath = "//td[@class='cart_quantity']/button[text()='" + quantity + "']";
        assertElementIsDisplayed(quantityXPath);
        logger.info("Verified product is displayed in cart page with exact quantity: " + quantity);
    }

    public void placeOrderRegWhileCheckout() {
        mainPage.verifyPageUrl("home");
        
        addToCart();
        logger.info("Item added to cart");
        
        mainPage.verifyPageUrl("cart");
        
        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout Clicked");
        
        click(cartPageElements.btnRegisterLogin);
        logger.info("Register/Login Clicked");
    }

    public void regBeforeCheckout() {
        
        addToCart();
        logger.info("Item added to cart");
        
        mainPage.verifyPageUrl("cart");
        logger.info("Verified cart page is displayed");
    }

    public void proceedToCheckout(String Description, String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        
        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout Clicked");
        
        assertElementIsDisplayed("//h2[normalize-space()='Address Details']");
        assertElementIsDisplayed("//h2[normalize-space()='Review Your Order']");
        logger.info("Verified Address Details and Review Your Order are visible");
        
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
        
        assertElementIsDisplayed("//p[contains(text(), 'Congratulations! Your order has been confirmed!')]");
        logger.info("Verified success message 'Your order has been placed successfully!'");
    }

    public void navigateBrands() {
        mainPage.clickTab("products");
        logger.info("Clicking Polo Brand");
        assertElementIsDisplayed(productsPageElements.brandPolo);
        click(productsPageElements.brandPolo);

        Assert.assertTrue(driver.getCurrentUrl().contains("brand_products"), "Failed to load Polo brand page");

        logger.info("Clicking H&M Brand");
        assertElementIsDisplayed(productsPageElements.brandHnM);
        
        click(productsPageElements.brandHnM);
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

    public void clickViewCartButton() {
        logger.info("Clicking on View Cart button");
        click(pageObjects.productsPageElements.btnViewCart);
    }
}