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
    protected String dropDownProfile = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";
    protected String logOutButton = "//header[@class='oxd-topbar']//li//ul//li//a[text()='Logout']";

    public void inputUsername(String input) {
        sendText(By.name(textAreaUsername), input);
    }

    public void inputPassword(String input) {
        sendText(By.name(textAreaPassword), input);
    }

    public void clickLogin() {
        click(By.xpath(buttonContinue));
    }

    public void logOutUser(){
        click(By.xpath(dropDownProfile));
        click(By.xpath(logOutButton));
    }

    public void validateInvalidLogin() {
        validateElementShow(By.xpath(errorMessage));
    }

    public void validateValidLogin() {
        validateElementShow(By.xpath(dashboardPageTitle)); //TODO
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
