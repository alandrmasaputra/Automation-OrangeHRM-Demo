package pom.NavigationBar;

import org.openqa.selenium.By;
import pom.BasePage;
import utilities.GeneralUtilities;

public class SideBarNavigation extends BasePage {
    protected String searchBar = "//input[@placeholder= 'Search']";
    protected String navigationMenu = "//ul[@class='oxd-main-menu']/li";
    protected String pageTitle = "//header/div[1]/div[1]//span";
    protected String textAreaPassword = "password";
    protected String confirmButton = "//div/button[2]";

    public void clickMenuByIndex(int index) {
        clickByOrder(navigationMenu, String.valueOf(index));
    }

    public void clickAllMenuByIndex() {
        String[] expectedTitles = {"Admin", "PIM", "Leave", "Time", "Recruitment", "PIM", "Performance"
                , "Dashboard", "Directory", "Maintenance", "Claim", "Buzz"};

        for (int i = 0; i < expectedTitles.length; i++) {

            clickMenuByIndex(i + 1); // XPath index starts at 1

            // input password for open maintenance menus
            if (i + 1 == 10) {
                System.out.println("Inputting password for open maintenance menu...");
                sendText(By.name(textAreaPassword), "admin123");
                click(By.xpath(confirmButton));
            }

            validateMenuPage(expectedTitles[i]);
        }
    }

    // validate each menu by Title
    public void validateMenuPage(String expectedTitle) {
        assertTrue(GeneralUtilities.validateArraysContainsString(getTexts(By.xpath(pageTitle)), expectedTitle));
    }


    public void inputSearchBar(String input) {
        sendText(By.xpath(searchBar), input);
    }

    public void clearSearchText() {
        clearEditTextV2(By.xpath(searchBar));
    }

    public void validateSearchBar(String input) {
        String lowerInput = input.toLowerCase();
        boolean found = false;

        // Cek list navigation by search
        String[] resultSearch;
        try {
            resultSearch = getTexts(By.xpath(navigationMenu));
        } catch (Exception e) {
            System.out.println("List tidak ditemukan");
            System.out.println(input + " adalah invalid search (negatif scenario)");
            assertFalse(found);
            return;
        }

        // Loop semua hasil list search dan validasi dan cetak
        System.out.println("Hasil pencarian untuk: " + input);
        for (String item : resultSearch) {
            if (item.toLowerCase().contains(lowerInput)) {
                System.out.println("Input " + input + " ditemukan" + "--> " + item);
                found = true;
            } else {
                System.out.println(item + "Seharusnya tidak ditemukan");
                found = false;
            }
        }
        assertTrue(found);
    }

}


