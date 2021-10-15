import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By cartCountLocator = By.id("spanCart");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductAddedToCart() {
        if(getCartCount() > 0){
            return true;
        }
        return false;
    }

    public void goToCart() {
    }

    public int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

}
