package pages.products;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.BasePage;

import java.math.BigDecimal;

/*
    This is reusable component. You can use it on everywhere where you have list
    of product miniatures. So use it on:
    - main page (popular products section)
    - search result page
    - page with some category

    About constructor:
    DefaultElementLocatorFactory -> factory will not find @FindBy elements in whole page
    but only inside WebElement that you passed to the class -> productMiniature
 */
public class ProductMiniaturePage extends BasePage {


    public ProductMiniaturePage(WebDriver driver, WebElement productMiniature) {
        super(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(productMiniature), this);
    }

    @FindBy(css = ".product-title")
    private WebElement name;

    @FindBy(className = "price")
    private WebElement price;

    @FindBy(className = "regular-price")
    private WebElement priceBeforeDiscount;

    @FindBy(css = ".discount-percentage")
    private WebElement discount;

    @FindBy(css = ".new")
    private WebElement newIndicator;

    @FindBy(className = "quick-view")
    private WebElement quickView;

    public String getName() {
        return name.getText();
    }

    public BigDecimal getPrice() {

        return new BigDecimal(price.getText().replace("$", ""));
    }

    public BigDecimal getPriceBeforeDiscount() {

        return new BigDecimal(priceBeforeDiscount.getText().replace("$", ""));
    }

    public String getDiscount() {
        return discount.getText();
    }

    public Boolean isNew() {
        try {
            return newIndicator.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Boolean isDiscounted() {
        try {
            return discount.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public QuickViewPage openQuickView() {
        System.out.println("I will open quick view for: " + name.getText());
        actionBuilder.moveToElement(name).perform();
        waitForElement(quickView);
        quickView.click();
        return new QuickViewPage(driver);
    }

    @Override
    public String toString() {
        String productDetails = "Name: " + getName() + " price: " + getPrice() + " is new: " + isNew();
        if (isDiscounted()) {
            productDetails += " and it's discounted by " + getDiscount() + "!!";
        }
        return productDetails;
    }
}
