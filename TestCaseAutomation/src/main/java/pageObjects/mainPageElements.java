package pageObjects;

public interface mainPageElements {
    // Login or Signup Button
    String tabLoginSignup = "//a[normalize-space()='Signup / Login']";
    String tabContactUs = "//a[normalize-space()='Contact us']";
    String tabTestCases = "//a[normalize-space()='Test Cases']";
    String tabProducts = "//a[@href='/products']";
    String txtSubscribeEmail = "//input[@id='susbscribe_email']";
    String btnSubscribe = "//button[@id='subscribe']";
    String tabCart = "//a[normalize-space()='Cart']";
    String btnViewProduct = "(//a[contains(text(),'View Product')])[1]";
    
    // Categories & Recommended Items
    String categoryWomen = "//a[normalize-space()='Women']";
    String categoryWomenDress = "//a[normalize-space()='Dress']";
    String categoryMen = "//a[normalize-space()='Men']";
    String categoryMenTshirts = "//a[normalize-space()='Tshirts']";
    String btnAddToCartRecommended = "//div[@class='recommended_items']//a[contains(@class,'add-to-cart')][1]";
    
    // Scrolling & Verification (Fixed Arrow & Banner XPaths)
    String btnScrollUpArrow = "//a[@id='scrollUp']";
    String txtFullFledgedBanner = "//h2[contains(text(),'Full-Fledged') or contains(text(),'practice website')]";
    String txtSubscription = "//h2[normalize-space()='Subscription']";
}