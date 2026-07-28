package pageObjects;

public interface mainPageElements {
 
    //Login or Signup Button
    String tabLoginSignup = "//a[normalize-space()='Signup / Login']";
    String tabContactUs = "//a[normalize-space()='Contact us']";
    String tabTestCases = "//a[normalize-space()='Test Cases']";
    String tabProducts = "//a[@href='/products']";
    String txtSubscribeEmail = "//input[@id='susbscribe_email']";
    String btnSubscribe = "//button[@id='subscribe']";
    String tabCart = "//a[normalize-space()='Cart']";
    String btnViewProduct = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/ul[1]/li[1]/a[1]";

}