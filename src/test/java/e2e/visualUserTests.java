package e2e;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class visualUserTests extends BaseTests {
    @Test
    public void visualUserScenario(){
        LoginPage loginPage =homePage.getLoginPage();
        loginPage.setUserName("visual_user");
        loginPage.setPassword(validPassword);
        ProductsPage productsPage=loginPage.clickOnSubmitButton();
        assertTrue(productsPage.getUrl().contains("inventory.html"));
        assertFalse(productsPage.ShoppingContainerVisualization());
    }
}
