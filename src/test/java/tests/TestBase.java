package tests;

import objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://osftest-min.wewn.lsb.opi.org.pl/app/");
    }

    public void login(LoginPage loginPage, String userName, String password) {
        loginPage.setLoginField(userName);
        loginPage.setPasswordField(password);
        loginPage.clickOnLoginButton();
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
