import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    private static final String MAIN_PAGE = "https://www.lcwaikiki.com/tr-TR/TR";
    private static final String MY_CART = "https://www.lcwaikiki.com/tr-TR/TR/sepetim";

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public void goToCart() {
        driver.navigate().to(MY_CART);
    }

    public boolean isHomePage(String currentUrl){
        if(MAIN_PAGE.equals(currentUrl)){
            return true;
        }
        return false;
    }
}
