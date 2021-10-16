import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final static String LOGIN_PAGE = "https://www.lcwaikiki.com/tr-TR/TR/giris";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        driver.navigate().to(LOGIN_PAGE);
        driver.findElement(By.id("LoginEmail")).sendKeys(LoginConfig.USER_MAIL);
        driver.findElement(By.id("Password")).sendKeys(LoginConfig.USER_PASSWORD);
        driver.findElement(By.id("loginLink")).click();
    }
}
