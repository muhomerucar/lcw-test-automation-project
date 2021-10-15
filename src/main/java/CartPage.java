import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By productNameLocator = By.className("rd-cart-item shoppingcart-item");
    By addProductLocator = By.className("oq-up plus");
    By deleteProductLocator = By.className("cart-square-link");
    By submitDeleteLocator = By.className("inverted-modal-button sc-delete ins-init-condition-tracking");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkProductQuantityUp() {
        return getProducts().size() > 0;
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }

    public void increaseQuantity(){
        click(addProductLocator);
        System.out.println("Product in the cart has been '+1' increased.");
    }

    public void deleteProductFromCart(){
        click(deleteProductLocator);
        System.out.println("Product is about to delete...");
        click(submitDeleteLocator);
        System.out.println("Product has been removed from cart.");
    }
}
