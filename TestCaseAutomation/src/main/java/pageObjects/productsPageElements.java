package pageObjects;

public interface productsPageElements {
    // Robust View Product selector
    String btnViewProduct = "(//a[contains(text(),'View Product')])[1]";
    String txtSearchProduct = "//input[@id='search_product']";
    String btnSearch = "//button[@id='submit_search']";
    String btnAddToCartFirstProduct = "(//a[contains(@class,'add-to-cart')])[1]";
    String btnAddToCartSecondProduct = "(//a[contains(@class,'add-to-cart')])[3]";
    String btnContinueShopping = "//button[normalize-space()='Continue Shopping']";
    String btnViewCart = "//u[normalize-space()='View Cart']";
    String btnCheckout = "//a[normalize-space()='Checkout']";

    String txtQuantity = "//input[@id='quantity']";
    String btnAddToCart = "//button[normalize-space()='Add to cart']";

    // Brands (Fixed to handle inner badges & encoding)
    String brandPolo = "//div[@class='brands_products']//a[contains(.,'Polo')]";
    String brandHnM = "//div[@class='brands_products']//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'h&m')]";

    // Product Review (Fixed Success Message selector)
    String txtReviewName = "//input[@id='name']";
    String txtReviewEmail = "//input[@id='email']";
    String txtReviewMessage = "//textarea[@id='review']";
    String btnSubmitReview = "//button[@id='button-review']";
    String txtReviewSuccessMsg = "//span[contains(text(),'Thank you for your review.')]";
}