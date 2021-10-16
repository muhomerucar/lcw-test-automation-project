import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class ProductDetailPage extends BasePage{

    By chooseSizeBeforeAddingCartLocator = By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[4]/div[1]/div[2]/div/div[1]/div[3]/a[1]");
    By addToCartButtonLocator = By.id("pd_add_to_cart");

    Log log = new Log();

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        click(chooseSizeBeforeAddingCartLocator);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        click(addToCartButtonLocator);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        log.info("Item has been added to cart");
    }
}
