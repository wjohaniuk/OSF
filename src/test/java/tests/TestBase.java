package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://osftest-min.wewn.lsb.opi.org.pl/app/");

    }


    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
