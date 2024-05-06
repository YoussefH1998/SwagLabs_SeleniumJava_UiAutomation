package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    WebDriver driver;
    private By userName= By.id("user-name");
    private By Password=By.id("password");
    private By loginButton=By.id("login-button");
    private By warningBox=By.xpath("//div/h3[@data-test='error']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void setUserName(String username){
        driver.findElement(userName).sendKeys(username);
    }
    public void setPassword (String password){
        driver.findElement(Password).sendKeys(password);
    }
    public String getUserName(){
        return driver.findElement(userName).getAttribute("value");
    }
    public String getPassword(){
        return driver.findElement(Password).getAttribute("value");
    }
    public String getWarningText(){
        return driver.findElement(warningBox).getText();
    }
    public void RefreshLoginPage(){
        driver.navigate().refresh();
    }
    public ProductsPage clickOnSubmitButton(){
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }
    public ProductsPage successfullogin(){
        setUserName("standard_user");
        setPassword("secret_sauce");
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }
}
