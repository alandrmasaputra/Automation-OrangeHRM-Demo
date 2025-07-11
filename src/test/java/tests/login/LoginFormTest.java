package tests.login;

import tests.BaseTest;
import org.testng.annotations.Test;

public class LoginFormTest extends BaseTest {
    String username = "Admin";
    String password = "admin123";

    @Test(priority = 1)
    public void usernamePasswordEmpty() {
        loginPage.clickLogin();
        loginPage.validateNullUsername();
        loginPage.validateNullPassword();
    }

    @Test(priority = 2)
    public void usernameEmpty() {
        loginPage.refreshPage();
        loginPage.inputPassword(password);
        loginPage.clickLogin();
        loginPage.validateNullUsername();
    }

    @Test(priority = 3)
    public void passwordEmpty() {
        loginPage.refreshPage();
        loginPage.inputUsername(username);
        loginPage.clickLogin();
        loginPage.validateNullPassword();
    }
}
