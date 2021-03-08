package pages.products;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

/*
    This class is used in 3 places: MainPage, SearchResultsPage, CategoryPage
 */
public class ListOfProductPage extends BasePage {
    public ListOfProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-miniature")
    private List<WebElement> products;

    public List<ProductMiniaturePage> getProducts() {
        return products.stream().map(product -> new ProductMiniaturePage(driver, product)).collect(Collectors.toList());
    }

    public ProductMiniaturePage getRandomProduct() {
        return new ProductMiniaturePage(driver, getRandomElement(products));
    }

    public QuickViewPage openQuickViewOfProduct(String name) throws Exception {
        for (ProductMiniaturePage product : getProducts()) {
            if (product.getName() == name) {
                product.openQuickView();
                return new QuickViewPage(driver);
            }
        }
        throw new Exception("No product found with name " + name);
    }
}