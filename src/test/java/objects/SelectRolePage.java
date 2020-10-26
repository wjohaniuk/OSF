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
    @FindBy(xpath = "//li[@class='fontSizeMedium'][1]/input")
    private WebElement rwRolePicker;
    @FindBy(xpath = "//li[@class='fontSizeMedium'][2]/input")
    private WebElement czsRolePicker;
    @FindBy(xpath = "//li[@class='fontSizeMedium'][3]/input")
    private WebElement pmRolePicker;
    @FindBy(xpath = "//li[@class='fontSizeMedium'][4]/input")
    private WebElement nCBiRRolePicker;
    @FindBy(xpath = "//li[@class='fontSizeMedium'][5]/input")
    private WebElement nPRHRolePicker;


    public SelectRolePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean cancelButtonIsVisible() {
        return cancelButton.isDisplayed();
    }

    public void clickOnContinueButton() {
        WaitForElement.waitUntilElementIsClickable(continueButton);
        continueButton.click();
        logger.info("klikniecie w przycisk kontynuuj");
    }

    public void clickOnCancelButton() {
        WaitForElement.waitUntilElementIsClickable(cancelButton);
        cancelButton.click();
        logger.info("klikniecie w przycisk anuluj");
    }

    public void setRwRolePicker() {
        rwRolePicker.click();
        logger.info("wybranie roli redktora wniosku");
    }

    public void setCzsRolePicker() {
        czsRolePicker.click();
        logger.info("wybranie roli pracownika MNiSW");
    }

    public void setPmRolePicker() {
        pmRolePicker.click();
    }

    public void setnCBiRRolePicker() {
        nCBiRRolePicker.click();
    }

    public void setnPRHRolePicker() {
        nPRHRolePicker.click();
    }


}
