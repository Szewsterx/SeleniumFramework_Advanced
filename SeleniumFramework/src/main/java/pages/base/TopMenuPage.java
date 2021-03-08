package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#_desktop_user_info a")
    private WebElement signInLink;

    public SignInPage signIn() {
        signInLink.click();
        return new SignInPage(driver);
    }
}
