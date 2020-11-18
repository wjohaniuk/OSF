package tests;

import driver.manager.DriverUtils;
import objects.WnioskodawcaDialog;
import org.testng.annotations.Test;

import static navigation.ApplicationURLs.WNIOSEK_DIALOG_URL;

public class UzupelnijWniosekDialogTest {

    @Test
    public void TestUzupelnieniaDialogu() {
        LoginTests loginTests = new LoginTests();
        loginTests.loginAsOSFEditor();
        DriverUtils.navigateToPage(WNIOSEK_DIALOG_URL);
        WnioskodawcaDialog wnioskodawcaDialog = new WnioskodawcaDialog();
        wnioskodawcaDialog.wyszukajWnioskodawce("Politechnika Warszawska");
    }


}
