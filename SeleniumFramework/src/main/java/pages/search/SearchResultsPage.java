package pages.search;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.base.TopMenuPage;
import pages.products.ListOfProductPage;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        topMenu = new TopMenuPage(driver);
        listOfProductPage = new ListOfProductPage(driver);
    }

    private TopMenuPage topMenu;
    private ListOfProductPage listOfProductPage;

    public TopMenuPage getTopMenu() {
        return topMenu;
    }

    public ListOfProductPage getListOfProducts() {
        return listOfProductPage;
    }
}
