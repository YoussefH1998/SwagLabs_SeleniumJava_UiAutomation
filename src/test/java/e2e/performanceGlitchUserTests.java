package e2e;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.assertTrue;

public class performanceGlitchUserTests extends BaseTests {
    @Test
    public void performanceglitchUserScenario(){
        homePage.setImplicitWait(10);
        LoginPage loginPage =homePage.getLoginPage();
        loginPage.setUserName("performance_glitch_user");
        loginPage.setPassword(validPassword);
        ProductsPage productsPage=loginPage.clickOnSubmitButton();
        assertTrue(productsPage.getUrl().contains("inventory.html"));
        String option="Price (low to high)";
        productsPage.selectByText(option);
        String s= productsPage.getMinPriceElementName();
        productsPage.setExplicitWait(s,30);
        assertTrue(productsPage.validatePriceOrder(productsPage.getProductListPrices()));
    }
}
