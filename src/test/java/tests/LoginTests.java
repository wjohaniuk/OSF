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
        loginPage.setLoginField("zlylogin")
                .setPasswordField("ZleHaslo")
                .clickOnLoginButton();
        Assert.assertEquals(loginPage.errorMsgLogin(), "Brak dostępu do Systemu - proszę podać poprawny login i hasło");
    }

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginField("automattest4")
                .setPasswordField("Test1234")
                .clickOnLoginButton();
        SelectRolePage selectRolePage = new SelectRolePage();
        Assert.assertTrue(selectRolePage.cancelButtonIsVisible());

    }

    @Test
    public void loginAsOSFEditor() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginField("automattest4")
                .setPasswordField("Test1234")
                .clickOnLoginButton();

        SelectRolePage selectRolePage = new SelectRolePage();
        selectRolePage.setRwRolePicker()
                .clickOnContinueButton();

        OSFEditorPage osfEditorPage = new OSFEditorPage();
        Assert.assertTrue(osfEditorPage.kafelWnioskiIsVisible());
    }

    @Test
    public void clickCancelOnSelectRolePage() {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginField("automattest4")
                .setPasswordField("Test1234")
                .clickOnLoginButton();

        SelectRolePage selectRolePage = new SelectRolePage();
        selectRolePage.setRwRolePicker()
                .clickOnCancelButton();

        Assert.assertEquals(loginPage.errorMsgLogin(), "Wylogowano.");
    }


}
