import org.openqa.selenium.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProductsPage extends BasePage{

    By productNameLocator = By.className("a_model_item");
    By seeMoreProductLocator = By.className("lazy-load-current");

    JavascriptExecutor js = ((JavascriptExecutor)driver);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getAllProducts(){
        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        return findAll(productNameLocator);
    }

    public void scrollDown(){
        js.executeScript("window.scrollBy(0,500)");
    }

    public void seeMoreProducts(){
        click(seeMoreProductLocator);
    }

    public WebElement selectRandomProduct(){
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        Random random = new Random();
        int randomProduct = random.nextInt(getAllProducts().size() - 1);
        return getAllProducts().get(randomProduct);
    }


}
