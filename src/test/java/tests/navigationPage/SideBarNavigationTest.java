package tests.navigationPage;

import org.testng.annotations.Test;
import tests.BaseTest;

public class SideBarNavigationTest extends BaseTest {
    @Test
    public void testAllMenu(){
        navigationPage.clickAllMenuByIndex();
    }
}
