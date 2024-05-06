package e2e;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.assertTrue;

public class problemUserTests extends BaseTests {
    @Test
    public void problemUserScenario(){
        LoginPage loginPage =homePage.getLoginPage();
        loginPage.setUserName("problem_user");
        loginPage.setPassword(validPassword);
        ProductsPage productsPage=loginPage.clickOnSubmitButton();
        assertTrue(productsPage.getUrl().contains("inventory.html"));
        boolean flag=productsPage.allImagesSame();
        assertTrue(flag);
    }
}
