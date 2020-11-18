package objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class WnioskodawcaDialog {
    private Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//span[contains(text(),'Wybierz z bazy OPI')]")
    private WebElement wybierzZbazyOPIButton;
    @FindBy(id = "wnioskodawcaForm:addInstitutionButton:j_idt366:name")
    private WebElement nazwaWnioskodawcyInput;
    @FindBy(xpath = "//span[contains(text(),'Wyszukaj')]")
    private WebElement wyszukajButton;
    @FindBy(xpath = "//div/button/span[contains(text(),'Wybierz')]")
    private WebElement wybierzWnioskodawceButton;

    public WnioskodawcaDialog() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public WnioskodawcaDialog wyszukajWnioskodawce(String nazwaWnioskodawcy) {
        wybierzZbazyOPIButton.click();
        WaitForElement.waitUntilElementIsClickable(nazwaWnioskodawcyInput);
        nazwaWnioskodawcyInput.click();
        nazwaWnioskodawcyInput.sendKeys(nazwaWnioskodawcy);
        wyszukajButton.click();
        WaitForElement.waitUntilElementIsClickable(wybierzWnioskodawceButton);
        wybierzWnioskodawceButton.click();
        return this;
    }

}
