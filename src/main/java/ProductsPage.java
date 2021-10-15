import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage{

    JavascriptExecutor js = ((JavascriptExecutor)driver);

    By filterOptionLocator = By.className("fixable-area filter-fixable-bar fixed");
    By productNameLocator = By.className("a_model_item");
    By seeMoreProductLocator = By.className("lazy-load-button");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        return isDisplayed(filterOptionLocator);
    }

    public List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }

    public void selectRandomProduct() {
        Random random = new Random();
        int randomProduct = random.nextInt(getAllProducts().size() - 1);
        getAllProducts().get(randomProduct).click();
    }

    public void scrollDown(){
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void seeMoreProducts(){
        click(seeMoreProductLocator);
    }
}
