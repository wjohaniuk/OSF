package objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OSFEditorPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "kafelWnioski")
    private WebElement kafelWnioski;
    @FindBy(id = "kafelNowyWniosek")
    private WebElement kafelNowyWniosek;
    @FindBy(id = "kafelRaporty")
    private WebElement kafelRaporty;
    @FindBy(id = "kafelPomoc")
    private WebElement kafelPomoc;

    public OSFEditorPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }
    public boolean kafelWnioskiIsVisible(){
        return kafelWnioski.isDisplayed();
    }
    public OSFEditorPage ClickOnNowyWnisoek(){
        kafelNowyWniosek.click();
        logger.info("klikniecie w Nowy wniosek");
        return this;
    }
}
