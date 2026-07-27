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

}
