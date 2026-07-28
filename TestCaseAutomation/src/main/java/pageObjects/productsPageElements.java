package pageObjects;

public interface productsPageElements {
    String btnViewProduct = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]";
    String txtSearchProduct = "//input[@id='search_product']";
    String btnSearch = "//button[@id='submit_search']";
    String btnAddToCartFirstProduct = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]";
    String btnAddToCartSecondProduct = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/a[1]";
    String btnContinueShopping = "//button[normalize-space()='Continue Shopping']";
    String btnViewCart = "//u[normalize-space()='View Cart']";
    String btnCheckout = "//a[normalize-space()='Checkout']";
    
    String txtQuantity = "//input[@id='quantity']";
    String btnAddToCart = "//button[normalize-space()='Add to cart']";
    
}
