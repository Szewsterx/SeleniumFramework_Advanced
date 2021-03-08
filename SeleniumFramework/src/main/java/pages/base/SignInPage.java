package pages.base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class SignInPage extends BasePage {

    SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#login-form input[name='email']")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement submitButton;

    @FindBy(css = ".alert-danger")
    private WebElement alertMessage;

    public SignInPage withEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public SignInPage withPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage submit() {
        submitButton.click();
        return new MainPage(driver);
    }

    public SignInPage submitWithoutSuccess() {
        submitButton.click();
        return this;
    }

    public boolean isAlertMessageDisplayed() {
        try {
            return alertMessage.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
}