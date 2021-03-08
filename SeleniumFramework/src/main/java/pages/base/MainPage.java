package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.products.ListOfProductPage;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        topMenu = new TopMenuPage(driver);
        listOfProductPage = new ListOfProductPage(driver);
    }

    @FindBy(className = "logo")
    private WebElement logo;

    private TopMenuPage topMenu;
    private ListOfProductPage listOfProductPage;

    public TopMenuPage getTopMenu() {
        return topMenu;
    }

    public ListOfProductPage getListOfProducts() {
        return listOfProductPage;
    }
}
