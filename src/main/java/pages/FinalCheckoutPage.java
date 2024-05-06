package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FinalCheckoutPage {
    WebDriver driver;
    private final By title= By.xpath("//span[@class='title']");
    private final By finish= By.id("finish");
    private final By cancel= By.id("cancel");
    private final By subTotal=By.xpath("//div[@class='summary_subtotal_label']");
    public FinalCheckoutPage(WebDriver driver){
        this.driver=driver;
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public CompletionPage checkOut(){
        driver.findElement(finish).click();
        return new CompletionPage(driver);
    }
    public void cancelCheckOut(){
        driver.findElement(cancel).click();
    }
    public double getTotalBeforeTax(){
        double d=Double.parseDouble(driver.findElement(subTotal).getText().split(" ")[2].substring(1));
        return d;
    }

}
