package objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OSFEditorPage {

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
}
