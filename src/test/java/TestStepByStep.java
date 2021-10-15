import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestStepByStep extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    SearchBox searchBox;

    WebDriverWait wait;

    @Test
    @Order(1)
    public void login(){
        loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @Test
    @Order(2)
    public void searchProduct(){
        homePage = new HomePage(driver);
        searchBox = new SearchBox(driver);
        homePage.searchBox().search("Pantolan");
        //Assertions.assertTrue(productsPage.isOnProductsPage(), "Not on products page!");
    }

    @Test
    @Order(3)
    public void scrollToBottomAndSeeMoreProduct(){
        productsPage = new ProductsPage(driver);
        productsPage.scrollDown();
        productsPage.seeMoreProducts();
    }

    @Test
    @Order(4)
    public void selectProduct(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectRandomProduct();
        //Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on  product detail page!");
    }

    @Test
    @Order(5)
    public void addProductToCart(){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.addToCart();
        //Assertions.assertTrue(homePage.isProductAddedToCart(), "Product has not been added to cart!");
    }

    @Test
    @Order(6)
    public void goToCart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        //Assertions.assertTrue(cartPage.checkProductQuantityUp(), "The product quantity in the cart has not been increased!");
    }

    @Test
    @Order(7)
    public void removeProductFromCart(){

    }
}
