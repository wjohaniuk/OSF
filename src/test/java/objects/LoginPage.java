package objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {
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

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void setLoginField(String username) {
        WaitForElement.waitUntillElementIsVisible(loginField);
        loginField.clear();
        loginField.sendKeys(username);
    }

    public void setPasswordField(String password) {
        WaitForElement.waitUntillElementIsVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String errorMsgLogin() {
        WaitForElement.waitUntillElementIsVisible(messagesLabel);
        return messagesLabel.getText();
    }
}
