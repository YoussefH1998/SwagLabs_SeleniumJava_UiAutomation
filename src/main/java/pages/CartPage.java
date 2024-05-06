package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    private final By continueShopping=By.id("continue-shopping");
    private final By checkOut=By.id("checkout");
    private final By cartItem=By.className("cart_item");
    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public int getProductsInBag(){
        return driver.findElements(cartItem).size();
    }
    public void ContinueShopping(){
        driver.findElement(continueShopping).click();
    }
    public CheckoutInformationPage checkOut(){
        driver.findElement(checkOut).click();
        return new CheckoutInformationPage(driver);
    }
}
