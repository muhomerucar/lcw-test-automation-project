import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TestStepByStep extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    String price1;
    Log log = new Log();
    private String searchText = "Pantolan";
    private String myCart = "https://www.lcwaikiki.com/tr-TR/TR/sepetim";

    @Test
    @Order(0)
    public void home(){
        homePage = new HomePage(driver);
        driver.getCurrentUrl();
        Assertions.assertTrue(homePage.isHomePage(driver.getCurrentUrl()));
    }

    @Test
    @Order(1)
    public void login(){
        loginPage = new LoginPage(driver);
        if(LoginConfig.USER_MAIL.equals("") || LoginConfig.USER_PASSWORD.equals("")){
            System.out.println("UserName or Password cannot be empty. Please enter your infos to LoginConfig.java file");
            log.error("UserName or Password cannot be empty. Please enter your infos to LoginConfig.java file");
        } else{
            loginPage.login();
        }
    }

    @Test
    @Order(2)
    public void searchProduct(){
        homePage = new HomePage(driver);
        homePage.searchBox().search(searchText);
    }

    @Test
    @Order(3)
    public void scrollToBottom(){
        productsPage = new ProductsPage(driver);
        productsPage.scrollDown();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    @Order(4)
    public void seeMoreProducts(){
        productsPage = new ProductsPage(driver);
        productsPage.seeMoreProducts();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        productsPage.scrollDown();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    @Order(5)
    public void selectProduct(){
        productsPage = new ProductsPage(driver);
        WebElement element = productsPage.selectRandomProduct();
        element.click();
        price1 = driver.findElement(By.xpath("//*[@id='rightInfoBar']/div[1]/div/div[2]/div/div/div/span[2]")).getAttribute("innerHTML");
    }

    @Test
    @Order(6)
    public void addProductToCart(){
        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        productDetailPage.addToCart();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.navigate().to(myCart);
        cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isProductAdded());
    }

    @Test
    @Order(7)
    public void goToCart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
    }

    @Test
    @Order(8)
    public void comparePrice(){
        cartPage = new CartPage(driver);
        String price = driver.findElement(By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[2]/div[1]/div[5]/div/span[2]")).getAttribute("innerHTML");
        Assertions.assertEquals(price.trim(), price1.trim());
    }

    @Test
    @Order(9)
    public void increaseQuantityOfSelectedProduct(){
        cartPage = new CartPage(driver);
        cartPage.increaseQuantity();
        Assertions.assertTrue(cartPage.checkProductQuantityUp());
    }


    @Test
    @Order(10)
    public void removeProductFromCart() {
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        cartPage.deleteProductFromCart();
    }

    @Test
    @Order(11)
    public void isCartOfUserEmpty(){
        cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isCartEmpty());
    }
}
