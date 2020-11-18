package tests;

import driver.manager.DriverUtils;
import objects.*;
import org.testng.annotations.Test;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class UtworzWniosekTest extends TestBase {
    @Test
    public void DodajWniosekDialogJakoRW() {
        DriverUtils.navigateToPage(APPLICATION_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginField("automattest4")
                .setPasswordField("Test1234")
                .clickOnLoginButton();
        SelectRolePage selectRolePage = new SelectRolePage();
        selectRolePage.setRwRolePicker()
                .clickOnContinueButton();
        OSFEditorPage osfEditorPage = new OSFEditorPage();
        osfEditorPage.ClickOnNowyWnisoek();
        PokazTypWnioskow pokazTypWnioskow = new PokazTypWnioskow();
        pokazTypWnioskow.ClickOnMNISW();
        pokazTypWnioskow.ClickOnDialog();
        NowyWniosekDialog nowyWniosekDialog = new NowyWniosekDialog();
        nowyWniosekDialog.PobierzKomunikat()
                .KliknijWOswiadczenie()
                .KliknijWUtworzWniosek()
                .CzyDodanyWniosek();


    }

}
