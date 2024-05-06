package products;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class ProductsTests extends BaseTests {
    ProductsPage productsPage;
    @BeforeClass
    public void productTestSetUp(){
        //Go to ProductsPage with standard user
        LoginPage loginPage =homePage.getLoginPage();
        productsPage=loginPage.successfullogin();
    }
    @Test
    public void validateAlphabeticSortingAscending(){
        //Checking sorting according to names in ascending order
        String option="Name (A to Z)";
        productsPage.selectByText(option);
        List<WebElement> productNames=productsPage.getProductListNames();
        assertTrue(productsPage.validateAlphabeticalOrder(productNames));
           }
    @Test
    public void validateAlphabeticSortingDescending(){
        //Checking sorting according to names in descending order
        String option="Name (Z to A)";
        productsPage.selectByText(option);
        List<WebElement> productNames=productsPage.getProductListNames();
        productNames=productsPage.reverseList(productNames);
        assertTrue(productsPage.validateAlphabeticalOrder(productNames));
    }
    @Test
    public void validatePriceSortingAscending(){
        //Checking sorting according to prices in ascending order
        String option="Price (low to high)";
        productsPage.selectByText(option);
        List<WebElement> productPrices=productsPage.getProductListPrices();
        assertTrue(productsPage.validatePriceOrder(productPrices));
    }
    @Test
    public void validatePriceSortingDescending(){
        //Checking sorting according to names in descending order
        String option="Price (high to low)";
        productsPage.selectByText(option);
        List<WebElement> productPrices=productsPage.getProductListPrices();
        productPrices=productsPage.reverseList(productPrices);
        assertTrue(productsPage.validatePriceOrder(productPrices));
    }
    @Test
    public void RemoveProducts(){
        //Checking removing product functionality
        String s="Sauce Labs Fleece Jacket";
        int actual=productsPage.getCurrentBag();
        if(actual==0){
            String option="Name (A to Z)";
            productsPage.selectByText(option);
            String[] target={"Sauce Labs Backpack","Sauce Labs Fleece Jacket"};
            productsPage.addProductsByName(target);
            actual=productsPage.getCurrentBag();
            assertEquals(actual,target.length,"Not all products were added");
        }
        productsPage.removeProduct(s);
        assertEquals(productsPage.getCurrentBag(),actual-1,"Product was not removed");
    }
    @Test
    public void AddProducts(){
        //Checking adding product functionality
        String option="Name (A to Z)";
        productsPage.selectByText(option);
        String[] target={"Sauce Labs Backpack","Sauce Labs Fleece Jacket"};
        productsPage.addProductsByName(target);
        int actual=productsPage.getCurrentBag();
        assertEquals(actual,target.length,"Not all products were added");
    }
}
