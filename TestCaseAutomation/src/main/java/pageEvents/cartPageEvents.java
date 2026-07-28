package pageEvents;

import org.testng.reporters.jq.Main;

import base.BaseTest;
import pageObjects.cartPageElements;
public class cartPageEvents extends BaseTest{
    
    mainPageEvents mainPage = new mainPageEvents();

    public void subscribe(String email){
        mainPage.clickCartTab();

        clear(cartPageElements.txtSubscribe);
        sendKeys(cartPageElements.txtSubscribe, email);
        
        click(cartPageElements.btnSubscribe);
        logger.info("Subscribed");
    }
}
