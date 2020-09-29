package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OSFEditorPage {
    private WebDriver driver;

    @FindBy(id = "kafelWnioski")
    private WebElement kafelWnioski;
    @FindBy(id = "kafelNowyWniosek")
    private WebElement kafelNowyWniosek;
    @FindBy(id = "kafelRaporty")
    private WebElement kafelRaporty;
    @FindBy(id = "kafelPomoc")
    private WebElement kafelPomoc;

    public OSFEditorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean kafelWnioskiIsVisible(){
        return kafelWnioski.isDisplayed();
    }
}
