package pageEvents;
import base.BaseTest;
import pageObjects.mainPageElements;
import org.testng.Assert;

public class mainPageEvents extends BaseTest{
    
    public void clickLoginSignupTab(){
        logger.info("Click Login/Signup tab");
        click(mainPageElements.tabLoginSignup);
        Assert.assertTrue(driver.getCurrentUrl().contains("login"),
                "User was not redirected to Login/Signup page.");
    }
    public void clickContactUs(){
        logger.info("Click Contact Us tab");
        click(mainPageElements.tabContactUs);
        Assert.assertTrue(driver.getCurrentUrl().contains("contact"),
                "User was not redirected to Contact Us page.");
    }
    public void clickTestCaseTab(){
        logger.info("Click Test Cases tab");
        click(mainPageElements.tabTestCases);
        logger.info("Test Cases tab Clicked");
    }
    public void clickProductsTab(){
        logger.info("Click Products tab");
        click(mainPageElements.tabProducts);
        logger.info("Products tab Clicked");
    }
    public void subscribe(String email){
        clear(mainPageElements.txtSubscribeEmail);
        sendKeys(mainPageElements.txtSubscribeEmail, email);
        click(mainPageElements.btnSubscribe);
        logger.info("Subscribed");
    }
    public void clickCartTab(){
        logger.info("Click Cart Tab");
        click(mainPageElements.tabCart);   
        logger.info("Cart Tab Clicked");
    }
    public void viewProduct(){
        click(mainPageElements.btnViewProduct);
        logger.info("View Product Clicked");
    }
}
