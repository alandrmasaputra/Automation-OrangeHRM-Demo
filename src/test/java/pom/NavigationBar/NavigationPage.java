package pom.NavigationBar;

import org.openqa.selenium.By;
import pom.BasePage;

public class NavigationPage extends BasePage {
    protected String searchBar = "//input[@placeholder= 'Search']";
    protected String resultSearchbar = "//ul/li/a/span";

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
            resultSearch = getTexts(By.xpath(resultSearchbar));
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


