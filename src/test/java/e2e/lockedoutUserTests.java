package e2e;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class lockedoutUserTests extends BaseTests {
    @Test
    public void lockedUserScenario(){
        LoginPage loginPage=homePage.getLoginPage();
        //user enters credential of locked user
        loginPage.setUserName("locked_out_user");
        loginPage.setPassword(validPassword);
        loginPage.clickOnSubmitButton();
        String warningText= loginPage.getWarningText();
        assertTrue(warningText.contains("Sorry, this user has been locked out."));
    }
}
