import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        driver.navigate().to("https://www.lcwaikiki.com/tr-TR/TR/giris");
        driver.findElement(By.id("LoginEmail")).sendKeys("ebraucar1@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("212Ebra!");
        driver.findElement(By.id("loginLink")).click();
    }
}
