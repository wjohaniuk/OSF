package tests;

import objects.LoginPage;
import objects.OSFEditorPage;
import objects.SelectRolePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @Test
    public void asUserLoginUsingInvalidLoginAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        login(loginPage, "asdasds", "xxxxxxxxx");
        Assert.assertEquals(loginPage.errorMsgLogin(), "Brak dostępu do Systemu - proszę podać poprawny login i hasło");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        SelectRolePage selectRolePage = new SelectRolePage(driver);
        login(loginPage, "automattest4", "Test1234");
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());

    }

    @Test
    public void loginAsOSFEditor() {
        LoginPage loginPage = new LoginPage(driver);
        SelectRolePage selectRolePage = new SelectRolePage(driver);
        OSFEditorPage osfEditorPage = new OSFEditorPage(driver);
        login(loginPage, "automattest4", "Test1234");
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());
        selectRolePage.setRwRolePicker();
        selectRolePage.clickOnContinueButton();
        Assert.assertTrue(osfEditorPage.kafelWnioskiIsVisible());
    }

    @Test
    public void clickCancelOnSelectRolePage() {
        LoginPage loginPage = new LoginPage(driver);
        SelectRolePage selectRolePage = new SelectRolePage(driver);
        login(loginPage, "automattest4", "Test1234");
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());
        selectRolePage.clickOnCancelButton();
        Assert.assertEquals(loginPage.errorMsgLogin(), "Wylogowano.");
    }


}
