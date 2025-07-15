package tests.navigationPage;

import org.testng.annotations.Test;
import tests.BaseTest;

public class TopBarNavigationTest extends BaseTest {
    @Test(priority = 1)
    public void clickAboutButton() {
        topBarNavigation.clickAbout();
    }

    @Test(priority = 2)
    public void clickSupportButton() {
        topBarNavigation.closeButtonPopUp();
        topBarNavigation.clickSupport();
    }

    @Test(priority = 3)
    public void clickChangePasswordButton() {
        topBarNavigation.clickChangePassword();
    }

    @Test(priority = 4)
    public void upgradeButton() {
        topBarNavigation.clickUpgrade();
    }

    @Test(priority = 5)
    public void clickLogOutButton() {
        topBarNavigation.clickLogOut();
    }
}
