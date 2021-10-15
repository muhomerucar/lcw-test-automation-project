import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage{

    By chooseSizeBeforeAddingCartLocator = By.className("option-size");
    By addToCartButtonLocator = By.id("pd_add_to_cart");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(chooseSizeBeforeAddingCartLocator);
        click(addToCartButtonLocator);
    }
}
