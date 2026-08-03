package pageEvents;

import base.BaseTest;
import pageObjects.mainPageElements;
import org.testng.Assert;

public class mainPageEvents extends BaseTest {

public void clickTab(String tab){

    switch(tab.toLowerCase()){

        case "home":
            click(mainPageElements.btnHome);
            break;

        case "cart":
            click(mainPageElements.tabCart);
            break;

        case "contact":
            click(mainPageElements.tabContactUs);
            break;

        case "products":
            click(mainPageElements.tabProducts);
            break;

        case "login":
            click(mainPageElements.tabLoginSignup);
            break;

        case "test_cases":
            click(mainPageElements.tabTestCases);
            
            break;

        default:
    }
}
public void verifyPageUrl(String page) {
    
    switch (page.toLowerCase()) {
        
        case "home":
            Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "Home page URL does not match!");
            logger.info("Verified that home page is visible successfully");
            break;
            
        case "login":
            Assert.assertTrue(driver.getCurrentUrl().contains("login"), "User was not navigated to the login page!");
            logger.info("Verified user is navigated to login page");
            break;
            
        case "cart":
            Assert.assertTrue(driver.getCurrentUrl().contains("view_cart"), "User was not navigated to the Cart page!");
            logger.info("Verified cart page is displayed successfully");
            break;
            
        case "contact":
            Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "User was not navigated to the contact page!");
            logger.info("Verified user is navigated to contact page");
            break;

        case "test_cases":
            Assert.assertTrue(driver.getCurrentUrl().contains("test_cases"), "User was not navigated to the Test Cases page!");
            logger.info("Verified user is navigated to test cases page successfully");
            break;

        case "products":
            Assert.assertTrue(driver.getCurrentUrl().contains("products"), "User was not navigated to the Products page!");
            logger.info("Verified user is navigated to ALL PRODUCTS page successfully");
            break;
        
        case "product_details":
            
            Assert.assertTrue(driver.getCurrentUrl().contains("product_details"), "User is not on the product details page!");
            logger.info("Verified user landed on product detail page");
            break;

        default:
            // This is a safety net. If you accidentally pass a typo like verifyPageUrl("hom"), 
            // it will instantly fail the test and tell you why.
            Assert.fail("The page requested ('" + page + "') is not defined in the verifyPageUrl method.");
            break;
    }
}
    
public void subscribe(String email) {
        
        verifyPageUrl("home");

        logger.info("Scrolled down to the footer");

        assertElementIsDisplayed("//h2[normalize-space()='Subscription']");
        logger.info("Verified text 'SUBSCRIPTION' is visible in the footer");

        logger.info("Subscribing with email: " + email);
        clear(mainPageElements.txtSubscribeEmail);
        sendKeys(mainPageElements.txtSubscribeEmail, email);
        click(mainPageElements.btnSubscribe);
        
        assertElementIsDisplayed("//div[contains(text(), 'You have been successfully subscribed!')]");
        logger.info("Verified success message 'You have been successfully subscribed!' is visible");
    }

    public void navigateCategories() {
        logger.info("Navigating Women Category");
        click(mainPageElements.categoryWomen);
        click(mainPageElements.categoryWomenDress);
        Assert.assertTrue(driver.getCurrentUrl().contains("category_products"), "Failed to navigate to Women Category");

        logger.info("Navigating Men Category");
        click(mainPageElements.categoryMen);
        click(mainPageElements.categoryMenTshirts);
        Assert.assertTrue(driver.getCurrentUrl().contains("category_products"), "Failed to navigate to Men Category");
    }

    public void addRecommendedItemToCart() {
        logger.info("Scrolling to recommended items and adding to cart");
        assertElementIsDisplayed(mainPageElements.btnAddToCartRecommended);
        click(mainPageElements.btnAddToCartRecommended);
    }

    public void verifyScrollUpWithArrow() {
        logger.info("Scrolling to bottom of page");
        assertElementIsDisplayed(mainPageElements.txtSubscription);
        try { Thread.sleep(1000); } catch (Exception e) {}
        click(mainPageElements.btnScrollUpArrow);
        try { Thread.sleep(1000); } catch (Exception e) {}
        assertElementIsDisplayed(mainPageElements.txtFullFledgedBanner);
        logger.info("Successfully scrolled up using arrow button");
    }

    public void verifyScrollUpWithoutArrow() {
        logger.info("Scrolling to bottom of page");
        assertElementIsDisplayed(mainPageElements.txtSubscription);
        assertElementIsDisplayed(mainPageElements.txtFullFledgedBanner);
        logger.info("Successfully scrolled up without arrow button");
    }
}