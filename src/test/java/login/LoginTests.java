package login;

import base.BaseTests;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.*;
public class LoginTests extends BaseTests {
    LoginPage loginPage;
    @BeforeClass
    public void loginTestSetUp(){
        loginPage =homePage.getLoginPage();
    }
    @AfterMethod(dependsOnMethods = "recordFailure")
    public void cleanUp(){
        loginPage.RefreshLoginPage();
    }
    @Test(priority = 1)
    public void userCanWriteInUsernameField(){
        //UserName field can be written in
        String userName="AnyUser";
        loginPage.setUserName(userName);
        assertEquals(loginPage.getUserName(),userName,"There is a Problem in UserNameField");
    }
    @Test(priority = 2)
    public void userCanWriteInPasswordField(){
        //Password field can be written in
        String password="Password";
        loginPage.setPassword(password);
        assertEquals(loginPage.getPassword(),password,"There is a Problem in Password");
    }
    @Test(priority = 3)
    public void EmptyUsername(){
        //user enters no username and valid password
        loginPage.setPassword(validPassword);
        loginPage.clickOnSubmitButton();
        String warningText= loginPage.getWarningText();
        assertTrue(warningText.contains("Username is required"));
    }
    @Test(priority = 4)
    public void EmptyPassword(){
        //user enters username but does not enter password
        loginPage.setUserName("locked_out_user");
        loginPage.clickOnSubmitButton();
        String warningText= loginPage.getWarningText();
        assertTrue(warningText.contains("Password is required"));
    }
    @Test(priority = 5)
    public void ValidUsernameInValidPassword(){
        //user enters invalid username but valid password
        loginPage.setUserName("standard_user");
        loginPage.setPassword("nnnn");
        loginPage.clickOnSubmitButton();
        String warningText= loginPage.getWarningText();
        assertTrue(warningText.contains("Username and password do not match any user in this service"));
    }
    @Test(priority = 6)
    public void InValidUsernameValidPassword(){
        //user enters invalid username but valid password
        loginPage.setUserName("MyUser");
        loginPage.setPassword(validPassword);
        loginPage.clickOnSubmitButton();
        String warningText= loginPage.getWarningText();
        assertTrue(warningText.contains("Username and password do not match any user in this service"));
    }
    @Test(priority = 7)
    public void InValidUsernameInValidPassword(){
        //user enters invalid username but valid password
        loginPage.setUserName("MyUser");
        loginPage.setPassword("Password");
        loginPage.clickOnSubmitButton();
        String warningText= loginPage.getWarningText();
        assertTrue(warningText.contains("Username and password do not match any user in this service"));
    }
    @Test(priority = 8)
    public void successfulLogin(){
        //user enters valid username and valid password
        loginPage.setUserName("standard_user");
        loginPage.setPassword(validPassword);
        ProductsPage productsPage=loginPage.clickOnSubmitButton();
        String url=productsPage.getUrl();
        assertTrue(url.contains("inventory"));
    }
}
