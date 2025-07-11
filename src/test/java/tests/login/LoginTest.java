package tests.login;

import tests.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String username = "Admin";
    String invalidUsername = "InvalidUsername";
    String password = "admin123";
    String invalidPassword = "awsalah123";

    @Test (priority = 2)
    public void validLoginTest() {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
        loginPage.validateValidLogin();
    }

    @Test (priority = 1)
    public void invalidLoginTest(){
        loginPage.refreshPage();
        loginPage.inputUsername(invalidUsername);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickLogin();
        loginPage.validateInvalidLogin();
    }
}
