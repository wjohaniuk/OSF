package objects;

import data.DataGenerators;
import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class WnioskodawcaDialog {
    private Logger logger = LogManager.getRootLogger();
    @FindBy (id="wnioskodawcaForm:addInstitutionButton:institution_browser_button_edit_dialog_title")
    private WebElement wyszukajSpan;
    @FindBy(xpath = "//span[contains(text(),'Wybierz z bazy OPI')]")
    private WebElement wybierzZbazyOPIButton;
    @FindBy(id = "wnioskodawcaForm:addInstitutionButton:j_idt366:name")
    private WebElement nazwaWnioskodawcyInput;
    @FindBy(xpath = "//span[contains(text(),'Wyszukaj')]")
    private WebElement wyszukajButton;
    @FindBy(xpath = "//div/button/span[contains(text(),'Wybierz')]")
    private WebElement wybierzWnioskodawceButton;
    @FindBy(xpath = "//div[@id='wnioskodawcaForm:daneWnioskodawcyId']//span[contains(text(),'Edytuj')]")
    private WebElement edytujDaneWnioskodawcyButton;
    @FindBy(id = "wnioskodawcaForm:epuapEdit")
    private WebElement adresSzkynkiEpuapEdycjaInput;
    @FindBy(id = "wnioskodawcaForm:nazwaBankuEdit")
    private WebElement nazwaBankuEdycjaInput;
    @FindBy(id = "wnioskodawcaForm:numerKontaEdit")
    private WebElement nrKontaBankowegoEdycjaInput;
    @FindBy(id = "wnioskodawcaForm:nipEdit")
    private WebElement nipEdycjaInput;
    @FindBy(xpath = "//div[@id='wnioskodawcaForm:nieDotyczy']//span")
    private WebElement krsNietotyczyEdycjaButton;
    @FindBy(id = "wnioskodawcaForm:krsEdit")
    private WebElement krsEdycjaInput;
    @FindBy(id = "wnioskodawcaForm:regonEdit")
    private WebElement regonEdycjaInput;
    @FindBy(id = "wnioskodawcaForm:daneWnioskodawcyId_edit_dialog_save_button")
    private WebElement zapiszEdycjaDaneWnioskodawcyButton;

    public WnioskodawcaDialog() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void poczekajNaZamkniecieOkna() throws InterruptedException {
        if (wyszukajSpan.isDisplayed()){
            Thread.sleep(4000);
        }
    }

    public WnioskodawcaDialog wyszukajWnioskodawce(String nazwaWnioskodawcy) {
        wybierzZbazyOPIButton.click();
        WaitForElement.waitUntilElementIsClickable(nazwaWnioskodawcyInput);
        nazwaWnioskodawcyInput.click();
        nazwaWnioskodawcyInput.sendKeys(nazwaWnioskodawcy);
        wyszukajButton.click();
        WaitForElement.waitUntilElementIsClickable(wybierzWnioskodawceButton);
        wybierzWnioskodawceButton.click();
        WaitForElement.waitUntilElementIsClickable(edytujDaneWnioskodawcyButton);
        logger.info("Wyszukanie wnioskodawcy");
        return this;
    }

    public WnioskodawcaDialog edytujDaneWnioskodawcy() throws InterruptedException {
        poczekajNaZamkniecieOkna();
        edytujDaneWnioskodawcyButton.click();
        WaitForElement.waitUntilElementIsClickable(adresSzkynkiEpuapEdycjaInput);
        adresSzkynkiEpuapEdycjaInput.clear();
        adresSzkynkiEpuapEdycjaInput.sendKeys("/pw/w");
        nazwaBankuEdycjaInput.clear();
        nazwaBankuEdycjaInput.sendKeys("Bank testowy");
        nrKontaBankowegoEdycjaInput.clear();
        nrKontaBankowegoEdycjaInput.sendKeys(DataGenerators.kontoBankowe());
        nipEdycjaInput.clear();
        nipEdycjaInput.sendKeys(DataGenerators.nipNumber());
        regonEdycjaInput.clear();
        regonEdycjaInput.sendKeys("000001554 ");
        krsEdycjaInput.clear();
        krsEdycjaInput.sendKeys("1223333333");
        zapiszEdycjaDaneWnioskodawcyButton.click();
        logger.info("Edytowanie danych wnioskodawcy");
        return this;
    }

}
