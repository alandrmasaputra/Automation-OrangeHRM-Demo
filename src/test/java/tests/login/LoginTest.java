package tests.login;

import tests.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String username = "Admin";
    String password = "admin123";
    @Test
    public void validLoginTest(){
        loginPage.inputUserNameAndPassword(username,password);
        loginPage.wait(3);
    }
}
