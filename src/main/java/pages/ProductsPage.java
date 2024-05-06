package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class ProductsPage {
    WebDriver driver;
    private final By dropDown=By.className("product_sort_container");
    private final By productsList=By.className("inventory_item");
    private final By productsListPrices=By.xpath("//div[@class='inventory_item_price']");
    private final By productsListNames=By.xpath("//div[@class='inventory_item_name ']");
    private final By addToCartButton=By.cssSelector("button[class*='primary']");
    private final By removeButton=By.cssSelector("button[class*='secondary']");
    private By shoppingBadge=By.className("shopping_cart_badge");
    private By shoppinglink=By.className("shopping_cart_link");
    private By shoppingContainer=By.id("shopping_cart_container");
    private By image=By.cssSelector("div[class*='inventory_item'] img");
    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void selectByText(String option){
        getDropDownList().selectByVisibleText(option);
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public List<WebElement> getProductsList(){
        return driver.findElements(productsList);
    }
    public List<WebElement> getProductListNames(){
        return driver.findElements(productsListNames);
    }
    public List<WebElement> getProductListPrices(){
        return driver.findElements(productsListPrices);
    }
    public List<WebElement> reverseList(List<WebElement> w){
        List<WebElement> rev=new ArrayList<>();
        for(int i=w.size()-1;i>=0;i--){
            rev.add(w.get(i));
        }
        return rev;

    }
    public boolean validateAlphabeticalOrder(List<WebElement> w){
        for(int i=0;i<w.size()-1;i++){
            if(w.get(i).getText().compareTo(w.get(i+1).getText())>0)
                return false;
        }
        return true;
    }
    public boolean validatePriceOrder(List<WebElement> w){
        for(int i=0;i<w.size()-1;i++){

            if(Double.parseDouble((w.get(i).getText().substring(1)))>Double.parseDouble((w.get(i+1).getText().substring(1))))
                return false;
        }
        return true;
    }
    public int binarySearch(List<WebElement> w ,String s) {
        int lower = 0;
        int upper = w.size() - 1;
        int index;
        while (true) {
            index = (lower + upper) / 2;
            if (w.get(index).getText().equals(s))
                return index;
            else if (lower > upper)
                return -1;
            else {
                if (w.get(index).getText().compareTo(s) < 0)
                    lower = index + 1;
                else
                    upper = index - 1;
            }
        }
    }
    public int getCurrentBag(){
        if(AllUnselected())
            return 0;
        return Integer.parseInt(driver.findElement(shoppingBadge).getText());
    }
    public void setExplicitWait(String s,int seconds){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(d -> getFirstElementName().equals(s));
    }
    public String getMinPriceElementName(){
            List<WebElement> products=getProductsList();
            double minPrice=Double.parseDouble(products.get(0).findElement(productsListPrices).getText().substring(1));
            int minIndex=0;
            for (int i=1;i<products.size();i++){
                double currPrice=Double.parseDouble(products.get(i).findElement(productsListPrices).getText().substring(1));
                if(currPrice<minPrice)
                {
                    minPrice=currPrice;
                    minIndex=i;
                }
            }
            return products.get(minIndex).findElement(productsListNames).getText();
    }
    public CartPage moveToPayment(){
        driver.findElement(shoppinglink).click();
        return new CartPage(driver);
    }
    private Select getDropDownList(){
        return new Select(driver.findElement(dropDown));
    }
    public boolean allImagesSame(){
        List<WebElement>w=getProductsList();
        for (int i=0;i<w.size()-1;i++){
            String img=w.get(i).findElement(image).getAttribute("src");
            String img2=w.get(i+1).findElement(image).getAttribute("src");
            if(!img.equals(img2))
                return false;
        }
        return true;
    }
    public boolean ShoppingContainerVisualization(){
        boolean b= driver.findElement(shoppingContainer).getAttribute("class").contains("visual_failure");
        return !b;
    }
    public void addProductByIndex(int index){
        driver.findElements(productsList).get(index).findElement(addToCartButton).click();
    }
    public double addProductsByName(String[] arr){
        List<WebElement> productNames=getProductListNames();
        List<WebElement> productPrices=getProductListPrices();
        //List<Integer> prevIndinces=new ArrayList<>();
        double sum=0.0;
        for(int i=0;i<arr.length;i++)
        {
            int c=binarySearch(productNames,arr[i]);
            addProductByIndex(c);
            sum+=Double.parseDouble(productPrices.get(c).getText().substring(1));
        }
        return sum;
    }
    public void removeProduct(String s){
        List<WebElement> productNames=getProductListNames();
        int c=binarySearch(productNames,s);
        removeProductByIndex(c);
    }
    public void removeProductByIndex(int index)
    {
        driver.findElements(productsList).get(index).findElement(removeButton).click();
    }
    private String getFirstElementName()
    {
        return getProductListNames().get(0).getText();
    }
    private String getFirstElementImage(){
        return getProductsList().get(0).findElement(image).getAttribute("src");
    }
    private boolean AllUnselected(){
        return driver.findElements(removeButton).size()==0;
    }
}
