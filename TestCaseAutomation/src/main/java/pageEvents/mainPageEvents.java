package pageEvents;

import base.BaseTest;
import pageObjects.mainPageElements;
import org.testng.Assert;

public class mainPageEvents extends BaseTest {

    public void clickLoginSignupTab() {
        logger.info("Click Login/Signup tab");
        // FIXED: Catch exception if ad blocks button or if already logged in
        try {
            click(mainPageElements.tabLoginSignup);
        } catch (Exception e) {
            driver.get(utils.Constants.url + "login");
        }
        try { Thread.sleep(1000); } catch (Exception e) {}
        if (driver.getCurrentUrl().contains("google_vignette") || !driver.getCurrentUrl().contains("login")) {
            driver.get(utils.Constants.url + "login");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "User was not redirected to Login/Signup page.");
    }

    public void clickContactUs() {
        logger.info("Click Contact Us tab");
        click(mainPageElements.tabContactUs);
        try { Thread.sleep(1000); } catch (Exception e) {}
        if (driver.getCurrentUrl().contains("google_vignette") || !driver.getCurrentUrl().contains("contact")) {
            driver.get(utils.Constants.url + "contact_us");
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("contact"),
                "User was not redirected to Contact Us page.");
    }

    public void clickTestCaseTab() {
        logger.info("Click Test Cases tab");
        click(mainPageElements.tabTestCases);
        logger.info("Test Cases tab Clicked");
    }

    public void clickProductsTab() {
        logger.info("Click Products tab");
        click(mainPageElements.tabProducts);
        try { Thread.sleep(1000); } catch (Exception e) {}
        if (driver.getCurrentUrl().contains("google_vignette") || !driver.getCurrentUrl().contains("products")) {
            driver.get(utils.Constants.url + "products");
        }
        logger.info("Products tab Clicked");
    }

    public void subscribe(String email) {
        clear(mainPageElements.txtSubscribeEmail);
        sendKeys(mainPageElements.txtSubscribeEmail, email);
        click(mainPageElements.btnSubscribe);
        logger.info("Subscribed");
    }

    public void clickCartTab() {
        logger.info("Click Cart Tab");
        click(mainPageElements.tabCart);
        try { Thread.sleep(1000); } catch (Exception e) {}
        if (driver.getCurrentUrl().contains("google_vignette") || !driver.getCurrentUrl().contains("view_cart")) {
            driver.get(utils.Constants.url + "view_cart");
        }
        logger.info("Cart Tab Clicked");
    }

    public void viewProduct() {
        click(mainPageElements.btnViewProduct);
        logger.info("View Product Clicked");
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