package pageEvents;

import java.util.Dictionary;
import java.util.Hashtable;

import base.BaseTest;
import pageObjects.cartPageElements;
import pageObjects.loginPageElements;
import pageObjects.productsPageElements;
import pageEvents.registerPageEvents;

public class productsEventPage extends BaseTest{
    Hashtable registerDetails;
    registerPageEvents registerPage = new registerPageEvents();   
    mainPageEvents mainPage = new mainPageEvents();
    
    public void clickViewProduct(){
        mainPage.clickProductsTab();
        click(productsPageElements.btnViewProduct);
        logger.info("View Product Clicked");
    }

    public void searchProduct(String product){
        mainPage.clickProductsTab();
        clear(productsPageElements.txtSearchProduct);
        sendKeys(productsPageElements.txtSearchProduct, product);
        click(productsPageElements.btnSearch);
        logger.info("Search Product Clicked");
    }

    public void addToCart(){
        mainPage.clickProductsTab();

        click(productsPageElements.btnAddToCartFirstProduct);
        logger.info("First Product Added to Cart");

        click(productsPageElements.btnContinueShopping);
        logger.info("Continue Shopping");

        click(productsPageElements.btnAddToCartSecondProduct);
        logger.info("Second Product Added to Cart");

        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");

    }
    public void quantityIncrease(String quantity){
        mainPage.viewProduct();

        clear(productsPageElements.txtQuantity);
        sendKeys(productsPageElements.txtQuantity, quantity);
        logger.info("Quantity Increased");

        click(productsPageElements.btnAddToCart);
        logger.info("Add to Cart Clicked");

        click(productsPageElements.btnViewCart);
        logger.info("View Cart Clicked");

    }

    public void placeOrderRegWhileCheckout(){
        addToCart();
        logger.info("Item added to cart");

        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout");

        click(cartPageElements.btnRegisterLogin);
        logger.info("Register/Login Clicked");

    }

    public void regBeforeCheckout(){
        addToCart();
        logger.info("Item added to cart");

    }
    public void proceedToCheckout(String Description, String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear){
        click(cartPageElements.btnProceedToCheckout);
        logger.info("Proceed to Checkout");

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
        
        logger.info("Your order has been placed successfully!");

        click(loginPageElements.btnDelete);
        logger.info("Validate User Deleted");


    }
}
