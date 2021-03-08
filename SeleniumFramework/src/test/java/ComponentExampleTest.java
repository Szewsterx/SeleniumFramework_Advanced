import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.MainPage;
import pages.products.ProductMiniaturePage;
import pages.products.QuickViewPage;

/*
    This is just example how we can use components
 */
public class ComponentExampleTest extends TestBase {

    private MainPage mainPage;

    @BeforeMethod
    public void testSetup() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void componentExampleTest() {
        for (ProductMiniaturePage product : mainPage.getListOfProducts().getProducts()) {
            System.out.println(product.toString());
        }
    }

    @Test
    public void someOtherExample() {
        for (ProductMiniaturePage product : mainPage.getListOfProducts().getProducts()) {
            if (product.getName().contains("...")) {
                System.out.println("OUCH have a look, this product name have been shortened: " + product.getName());
            }
        }
    }

    @Test
    public void openRandomProductQuickView() {
        QuickViewPage quickViewPage = mainPage.getListOfProducts().getRandomProduct().openQuickView();
        // it will close fast but yeah quick view is being opened for random product
    }
}
