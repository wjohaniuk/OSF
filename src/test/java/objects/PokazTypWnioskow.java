package objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PokazTypWnioskow {
    private Logger logger = LogManager.getRootLogger();
    @FindBy(id = "NOWE_WNIOSKI_MNISW")
    private WebElement noweWnioskiMNISW;

    @FindBy(id = "NOWE_WNIOSKI_NCBIR")
    private WebElement noweWnioskiNCBIR;

    @FindBy(id = "NOWE_WNIOSKI_NCN")
    private WebElement noweWnioskiNCN;

    @FindBy(xpath = "//a[contains(text(),\"Dialog\")]")
    private WebElement wniosekDialog;


    public PokazTypWnioskow(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
    public PokazTypWnioskow ClickOnMNISW(){
        noweWnioskiMNISW.click();
        logger.info("Kliknięty MNISW wniosek");
        return this;
    }
    public PokazTypWnioskow ClickOnNCBIR(){
        noweWnioskiNCBIR.click();
        logger.info("Kliknięto we wniosek NCBIR");
        return this;
    }

    public PokazTypWnioskow ClickOnNCN(){
        noweWnioskiNCN.click();
        logger.info("Kliknięto we wniosek NCN");
        return this;
    }

    public PokazTypWnioskow ClickOnDialog(){
        wniosekDialog.click();
        logger.info("Wybierz wniosek dialog");
        return this;
    }

}
