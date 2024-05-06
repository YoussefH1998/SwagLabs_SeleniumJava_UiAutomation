package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    WebDriver driver;
    private final By firstName=By.id("first-name");
    private final By lastName=By.id("last-name");
    private final By postalCode=By.id("postal-code");
    private final By continueButton=By.xpath("//input[@id='continue']");
    private final By cancelButton=By.xpath("//button[@id='cancel']");
    public CheckoutInformationPage(WebDriver driver){
        this.driver=driver;
    }
    public void setFirstName(String fName){
        driver.findElement(firstName).sendKeys(fName);
    }
    public void setLastName(String lName){
        driver.findElement(lastName).sendKeys(lName);
    }
    public void setPostalCode(String pCode){
        driver.findElement(postalCode).sendKeys(pCode);
    }
    public FinalCheckoutPage continueCheckOut(){
        driver.findElement(continueButton).click();
        return new FinalCheckoutPage(driver);
    }
    public void cancelCheckOut(){
        driver.findElement(cancelButton).click();
    }
    public String getLastName() {
       return  driver.findElement(lastName).getText();
    }
}
