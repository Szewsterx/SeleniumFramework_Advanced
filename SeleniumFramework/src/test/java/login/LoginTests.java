package login;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.base.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends TestBase {

    private MainPage mainPage;

    @BeforeMethod
    public void testSetup() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void loginWithNotExistingUser() {
        assertThat(
                mainPage.getTopMenu().signIn()
                        .withEmail("non@existing.mail")
                        .withPassword("strongPassword")
                        .submitWithoutSuccess()
                        .isAlertMessageDisplayed())
                .isTrue();
    }
}
