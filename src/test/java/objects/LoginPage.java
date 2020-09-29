package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "haslo")
    private WebElement passwordField;

    @FindBy(xpath = "//a[contains(text(),'Zarejestruj się jako redaktor wniosków')]")
    private WebElement registrationButton;

    @FindBy(xpath = "//button[contains(text(),'Zaloguj')]")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='form-error__msg']")
    private WebElement messagesLabel;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setLoginField(String username){
        loginField.clear();
        loginField.sendKeys(username);
    }

    public void setPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
    loginButton.click();
    }

    public String errorMsgLogin(){
        return messagesLabel.getText();
    }
}
