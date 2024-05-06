package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletionPage {
    WebDriver driver;
    private final By title= By.xpath("//span[@class='title']");
    private final By header= By.className("complete-header");
    private final By text= By.className("complete-text");
    public CompletionPage(WebDriver driver){
        this.driver=driver;
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public String getHeaderText(){
        return driver.findElement(header).getText();
    }
    public String getorderDeliveryText(){
        return driver.findElement(text).getText();
    }
}
