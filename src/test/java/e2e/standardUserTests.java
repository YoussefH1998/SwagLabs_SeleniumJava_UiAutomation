package e2e;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;
import static org.testng.Assert.*;

public class standardUserTests extends BaseTests {
    @Test
    public void standardUserScenario(){
        LoginPage loginPage =homePage.getLoginPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword(validPassword);
        ProductsPage productsPage=loginPage.clickOnSubmitButton();
        assertTrue(productsPage.getUrl().contains("inventory.html"));
        assertTrue(productsPage.ShoppingContainerVisualization());
        String option="Name (A to Z)";
        productsPage.selectByText(option);
        String[] target={"Sauce Labs Backpack","Sauce Labs Fleece Jacket"};
        double expectedPay=productsPage.addProductsByName(target);
        int actual=productsPage.getCurrentBag();
        assertEquals(actual,target.length,"Not all products were added");
        CartPage cartPage=productsPage.moveToPayment();
        assertTrue(cartPage.getUrl().contains("cart.html"));
        actual=cartPage.getProductsInBag();
        assertEquals(actual,target.length,"Not all products were added");
        CheckoutInformationPage checkoutInformationPage=cartPage.checkOut();
        checkoutInformationPage.setFirstName("aaa");
        checkoutInformationPage.setLastName("bbb");
        checkoutInformationPage.setPostalCode("123");
        FinalCheckoutPage finalCheckoutPage=checkoutInformationPage.continueCheckOut();
        double actualPay=finalCheckoutPage.getTotalBeforeTax();
        assertEquals(actualPay,expectedPay,"Prices are not matching");
        CompletionPage completionPage=finalCheckoutPage.checkOut();
        assertTrue(completionPage.getTitle().contains("Checkout: Complete!"));
        assertTrue(completionPage.getHeaderText().contains("Thank you"));
        assertTrue(completionPage.getorderDeliveryText().contains("Your order has been dispatched"));
    }
}
