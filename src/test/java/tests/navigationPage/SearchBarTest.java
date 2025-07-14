package tests.navigationPage;

import org.testng.annotations.Test;
import tests.BaseTest;

public class SearchBarTest extends BaseTest {
    String inputValid = "ec";
    String inputInvalid = "ecd";

    @Test(priority = 1)
    public void searchValid(){
        navigationPage.inputSearchBar(inputValid);
        navigationPage.validateSearchBar(inputValid);
    }

    @Test(priority = 2)
    public void searchInvalid(){
        navigationPage.clearSearchText();
        navigationPage.inputSearchBar(inputInvalid);
        navigationPage.validateSearchBar(inputInvalid);
    }
}
