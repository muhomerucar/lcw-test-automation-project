import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.id("search_input");
    By submitButtonLocator = By.cssSelector("[type='button']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        driver.findElement(By.id("search_input")).clear();
        type(searchBoxLocator, text);
        click(submitButtonLocator);
    }
}
