package tests.login;

import org.testng.annotations.Test;
import tests.BaseTest;

public class ForgotPasswordTest extends BaseTest {

    @Test(priority = 1)
    public void cancelForgotPassword() {
        loginPage.clickForgotPassword();
        loginPage.cancelResetPassword();
    }

    @Test(priority = 2)
    public void resetPasswordForm() {
        loginPage.clickForgotPassword();
        loginPage.clickResetPassword();
        loginPage.validateNullUsername();
    }

    @Test(priority = 3)
    public void resetPassword() {
        loginPage.inputUsername("Admin");
        loginPage.clickResetPassword();
        loginPage.validateResetPasswordLinkSent();
    }
}
