package pom.NavigationBar;

import org.openqa.selenium.By;
import pom.BasePage;

public class TopBarNavigation extends BasePage {
    protected String dropDownProfile = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";
    protected String aboutButton = "//header[@class='oxd-topbar']//li//ul//li//a[text()='About']";
    protected String supportButton = "//header[@class='oxd-topbar']//li//ul//li//a[text()='Support']";
    protected String changePasswordButton = "//header[@class='oxd-topbar']//li//ul//li//a[text()='Change Password']";
    protected String logOutButton = "//header[@class='oxd-topbar']//li//ul//li//a[text()='Logout']";
    protected String popUpAbout = "//div[@role='document']";
    protected String closePopUpButton = "//div[@role= 'document']/button";
    protected String supportPage = "//div[@class= 'orangehrm-support']/div/div/p/a";
    protected String changePasswordPage = "//form[@class = 'oxd-form']";
    protected String upgradeButton = "//header/div/div[2]/a/button";

    public void clickAbout (){
        click(By.xpath(dropDownProfile));
        click(By.xpath(aboutButton));
        validateElementShow(By.xpath(popUpAbout));
    }

    public void clickUpgrade (){
        String originalWindow = driver.getWindowHandle(); // save original tab

        click(By.xpath(upgradeButton));

        // switch to new tab open before validate to get new URL
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Validate the link opened
        validateNewURL("https://orangehrm.com/open-source/upgrade-to-advanced");

        driver.close();
        driver.switchTo().window(originalWindow); // switch to original tab
    }

    public void validateNewURL (String expectedUrlPart){
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL tab baru: " + currentUrl);
        assertTrue(currentUrl.contains(expectedUrlPart));
    }

    public void closeButtonPopUp (){
        click(By.xpath(closePopUpButton));
    }

    public void clickSupport() {
        click(By.xpath(dropDownProfile));
        click(By.xpath(supportButton));
        validateElementShow(By.xpath(supportPage));
    }

    public void clickChangePassword() {
        click(By.xpath(dropDownProfile));
        click(By.xpath(changePasswordButton));
        validateElementShow(By.xpath(changePasswordPage));
    }

    public void clickLogOut(){
        click(By.xpath(dropDownProfile));
        click(By.xpath(logOutButton));
    }

}
