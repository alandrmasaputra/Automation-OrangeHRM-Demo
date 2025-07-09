package tests.login;

import tests.BaseTest;
import org.testng.annotations.Test;

public class LoginFormTest extends BaseTest {
    String username = "Admin";
    String password = "admin123";

    @Test(priority = 1)
    public void usernamePasswordEmpty() {
        loginPage.clickLogin();
        loginPage.wait(3);
        loginPage.validateNullUsername();
        loginPage.validateNullPassword();
        loginPage.refreshPage();
    }

    @Test(priority = 2)
    public void usernameEmpty() {
        loginPage.inputPassword(password);
        loginPage.clickLogin();
        loginPage.wait(3);
        loginPage.validateNullUsername();
        loginPage.refreshPage();
    }

    @Test(priority = 3)
    public void passwordEmpty() {
        loginPage.inputUsername(username);
        loginPage.clickLogin();
        loginPage.wait(3);
        loginPage.validateNullPassword();
    }
}
