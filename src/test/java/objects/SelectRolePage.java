package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Wyjaśnienie ról do wyboru:
//1 - chcę się zalogować z uprawnieniami redaktora/redaktora pomocniczego/czytelnika ORAZ kierownika projektów we wnioskach OSF
//2 - chcę się zalogować z uprawnieniami członka zespołu specjalistycznego/interdyscyplinarnego
//3 - chcę się zalogować z uprawnieniami pracownika Ministerstwa
//4 - chcę się zalogować z uprawnieniami recenzenta wniosków do NCBiR lub do NFOŚiGW
//5 - chcę się zalogować z uprawnieniami recenzenta wniosków NPRH od 2016 roku

public class SelectRolePage {
    private WebDriver driver;

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


    public SelectRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean cancelButtonIsVisible(){
        return cancelButton.isDisplayed();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    public void setRwRolePicker(){
        rwRolePicker.click();
    }
    public void setCzsRolePicker(){
        czsRolePicker.click();
    }
    public void setPmRolePicker(){
        pmRolePicker.click();
    }
    public void setnCBiRRolePicker(){
        nCBiRRolePicker.click();
    }
    public void setnPRHRolePicker(){
        nPRHRolePicker.click();
    }


}
