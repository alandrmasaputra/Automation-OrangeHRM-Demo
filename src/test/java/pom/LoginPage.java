package pom;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    protected String textAreaUsername = "username";
    protected String textAreaPassword = "password";
    protected String buttonContinue = "//button[@type = 'submit']";

    public void inputUserNameAndPassword(String username, String password) {
        sendText(By.name(textAreaUsername), username);
        sendText(By.name(textAreaPassword), password);
        click(By.xpath(buttonContinue));
    }
}
