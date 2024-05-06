package e2e;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class errorUserTests extends BaseTests {
    @Test
    public void errorUserScenario(){
        LoginPage loginPage =homePage.getLoginPage();
        loginPage.setUserName("error_user");
        loginPage.setPassword(validPassword);
        ProductsPage productsPage=loginPage.clickOnSubmitButton();
        assertTrue(productsPage.getUrl().contains("inventory.html"));
        String option="Name (Z to A)";
        productsPage.selectByText(option);
        String text=productsPage.getAlertText();
        assertEquals(text,"Sorting is broken! This error has been reported to Backtrace.");
        productsPage.acceptAlert();
        CartPage cartPage=productsPage.moveToPayment();
        CheckoutInformationPage checkoutInformationPage=cartPage.checkOut();
        checkoutInformationPage.setLastName("abbbb");
        int size=checkoutInformationPage.getLastName().length();
        assertEquals(size,0);
    }
}
