import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage{

    By productNameLocator2 = By.xpath("//*[@id='ShoppingCartContent']/div[1]/div[1]/div[2]/div[1]");
    By addProductLocator = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/a[2]");
    By currentQuantity = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/input");
    By deleteProductMainButton = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div/a[1]/i");
    By cartEmptyLocator = By.className("cart-empty-title");
    By cardId = By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div/a[1]");
    Log log = new Log();

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkProductQuantityUp() {
        WebElement quantity = driver.findElement(currentQuantity);
        String quantityOfProduct = quantity.getAttribute("value");
        return Integer.valueOf(quantityOfProduct) > 1;
    }

    public void increaseQuantity(){
        click(addProductLocator);
        log.info("Product in the cart has been '+1' increased.");
    }

    public void deleteProductFromCart(){
        click(deleteProductMainButton);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String productId  = driver.findElement(cardId).getAttribute("cartitemid");
        driver.findElement(By.xpath("//*[@id='cartItemDeleteModal_"+ productId + "']/div/div/div[3]/div/div/a[1]")).click();
        log.info("Product is deleted ProductID : "+ productId);
    }

    public boolean isCartEmpty(){
        return isDisplayed(cartEmptyLocator);
    }

    public boolean isProductAdded(){
        return isDisplayed(productNameLocator2);
    }
}