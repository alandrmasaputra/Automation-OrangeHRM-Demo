package pom;

import org.openqa.selenium.By;
import utilities.GeneralUtilities;

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
    protected String forgotPasswordButton = "//form/div/p";
    protected String cancelForgotPassword = "//div/button[1]";
    protected String resetPasswordButton = "//div/button[2]";
    protected String labelSuccessResetPassword = "//div/h6";

    public void clickForgotPassword() {
        click(By.xpath(forgotPasswordButton));
    }

    public void cancelResetPassword() {
        click(By.xpath(cancelForgotPassword));
    }

    public void clickResetPassword() {
        click(By.xpath(resetPasswordButton));
    }

    public void inputUsername(String input) {
        sendText(By.name(textAreaUsername), input);
    }

    public void inputPassword(String input) {
        sendText(By.name(textAreaPassword), input);
    }

    public void clickLogin() {
        click(By.xpath(buttonContinue));
    }

    public void logOutUser() {
        click(By.xpath(dropDownProfile));
        click(By.xpath(logOutButton));
    }

    public void validateResetPasswordLinkSent() {
        validateElementShow(By.xpath(labelSuccessResetPassword));
    }

    public void validateInvalidLogin() {
        validateElementShow(By.xpath(errorMessage));
    }

    public void validateValidLogin() {
        System.out.println("Validate login will direct to Dashboard");
        assertTrue(GeneralUtilities.validateArraysContainsString(getTexts(By.xpath(dashboardPageTitle)), "Dashboard"));
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
