package objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class NowyWniosekDialog {
    private Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//a[contains(text(),'Pobierz komunikat')]")
    private WebElement pobierzKomunikatPrzycisk;
    @FindBy(xpath = "//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")
    private WebElement oswiadczenie;
    @FindBy(id = "tworzenieWnioskuDialogForm:zaRokId_panel")
    private WebElement rokDropdown;
    @FindBy(xpath = "//button/span[contains(text(),'Utwórz wniosek')]")
    private WebElement utworzWniosekButton;
    @FindBy(xpath = "//button/span[contains(text(),'Anuluj')]")
    private WebElement anulujButton;
    @FindBy(xpath = "//div/label[contains(text(),'ID wniosku')]/following::div[@class='ui-panelgrid-cell ui-grid-col-8'][1]")
    private WebElement idWniosku;

    public NowyWniosekDialog() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public NowyWniosekDialog PobierzKomunikat() {
        pobierzKomunikatPrzycisk.click();
        logger.info("Klikniecie w pobieranie komunikatu");
        return this;
    }

    public NowyWniosekDialog KliknijWOswiadczenie() {
        WaitForElement.waitUntilElementIsClickable(oswiadczenie);
        oswiadczenie.click();
        logger.info("Zaznaczenie oświadczenia");
        return this;
    }

    public NowyWniosekDialog KliknijWUtworzWniosek() {
        utworzWniosekButton.click();
        logger.info("Klikniecie w przycisk utworz wniosek");
        return this;
    }
    public boolean CzyDodanyWniosek(){
        WaitForElement.waitUntillElementIsVisible(idWniosku);
        logger.info("Wniosek o numerze: " + idWniosku.getText() + " został utworzony.");
        return idWniosku.isDisplayed();

    }
}
