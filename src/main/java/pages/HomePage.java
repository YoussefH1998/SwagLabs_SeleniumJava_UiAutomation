package pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public void setImplicitWait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

}
