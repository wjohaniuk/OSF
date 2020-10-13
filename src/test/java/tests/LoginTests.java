package tests;

import objects.LoginPage;
import objects.OSFEditorPage;
import objects.SelectRolePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @Test
    public void asUserLoginUsingInvalidLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        login(loginPage, "asdasds", "xxxxxxxxx");
        Assert.assertEquals(loginPage.errorMsgLogin(), "Brak dostępu do Systemu - proszę podać poprawny login i hasło");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        SelectRolePage selectRolePage = new SelectRolePage();
        login(loginPage, "automattest4", "Test12345");
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());

    }

    @Test
    public void loginAsOSFEditor() {
        LoginPage loginPage = new LoginPage();
        SelectRolePage selectRolePage = new SelectRolePage();
        OSFEditorPage osfEditorPage = new OSFEditorPage();
        login(loginPage, "automattest4", "Test12345");
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());
        selectRolePage.setRwRolePicker();
        selectRolePage.clickOnContinueButton();
        Assert.assertTrue(osfEditorPage.kafelWnioskiIsVisible());
    }

    @Test
    public void clickCancelOnSelectRolePage() {
        LoginPage loginPage = new LoginPage();
        SelectRolePage selectRolePage = new SelectRolePage();
        login(loginPage, "automattest4", "Test12345");
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());
        selectRolePage.clickOnCancelButton();
        Assert.assertEquals(loginPage.errorMsgLogin(), "Wylogowano.");
    }


}
