package objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

//Wyjaśnienie ról do wyboru:
//1 - chcę się zalogować z uprawnieniami redaktora/redaktora pomocniczego/czytelnika ORAZ kierownika projektów we wnioskach OSF
//2 - chcę się zalogować z uprawnieniami członka zespołu specjalistycznego/interdyscyplinarnego
//3 - chcę się zalogować z uprawnieniami pracownika Ministerstwa
//4 - chcę się zalogować z uprawnieniami recenzenta wniosków do NCBiR lub do NFOŚiGW
//5 - chcę się zalogować z uprawnieniami recenzenta wniosków NPRH od 2016 roku

public class SelectRolePage {
    private Logger logger = LogManager.getRootLogger();
    @FindBy(id = "buttonCancel")
    private WebElement cancelButton;
    @FindBy(id = "buttonContinue")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@id='rola_rw']")
    private WebElement rwRolePicker;
    @FindBy(xpath = "///input[@id='rola_50']")
    private WebElement czsRolePicker;
    @FindBy(xpath = "//input[@id='rola_150']")
    private WebElement nCBiRRolePicker;
    @FindBy(xpath = "//input[@id='rola_70']")
    private WebElement nPRHRolePicker;


    public SelectRolePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean cancelButtonIsVisible() {
        return cancelButton.isDisplayed();
    }

    public SelectRolePage clickOnContinueButton() {
        WaitForElement.waitUntilElementIsClickable(continueButton);
        continueButton.click();
        logger.info("klikniecie w przycisk kontynuuj");
        return this;
    }

    public void clickOnCancelButton() {
        WaitForElement.waitUntilElementIsClickable(cancelButton);
        cancelButton.click();
        logger.info("klikniecie w przycisk anuluj");
    }

    public SelectRolePage setRwRolePicker() {
        rwRolePicker.click();
        logger.info("wybranie roli redktora wniosku");
        return this;
    }

    public SelectRolePage setCzsRolePicker() {
        czsRolePicker.click();
        logger.info("wybranie roli pracownika MNiSW");
        return this;
    }

    public SelectRolePage setnCBiRRolePicker() {
        nCBiRRolePicker.click();
        return this;
    }

    public SelectRolePage setnPRHRolePicker() {
        nPRHRolePicker.click();
        return this;
    }


}
