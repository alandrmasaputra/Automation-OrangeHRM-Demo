package pom;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    protected String textAreaUsername = "username";
    protected String textAreaPassword = "password";
    protected String buttonContinue = "//button[@type = 'submit']";
    protected String errorMessage = "//div[@role = 'alert']";
    protected String dashboardPageTitle = "//header/div[1]/div[1]//span";
    protected String errorLabelUsername = "//form/div[1]//span[text()='Required']";
    protected String errorLabelPassword = "//form/div[2]//span[text()='Required']";
    protected String Test = "";
    //add comment
    
    public void inputUsername(String input) {
        sendText(By.name(textAreaUsername), input);
    }

    public void inputPassword(String input) {
        sendText(By.name(textAreaPassword), input);
    }

    public void clickLogin() {
        click(By.xpath(buttonContinue));
    }

    public void validateInvalidLogin() {
        validateElementShow(By.xpath(errorMessage));
    }

    public void validateValidLogin() {
        validateElementShow(By.xpath(dashboardPageTitle));
    }

    public void validateNullUsername() {
        validateElementShow(By.xpath(errorLabelUsername));
    }

    public void validateNullPassword() {
        validateElementShow(By.xpath(errorLabelPassword));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
