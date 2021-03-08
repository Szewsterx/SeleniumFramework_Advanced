package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actionBuilder;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actionBuilder = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    protected void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElements(By by, int expectedAmount) {
        wait.until(ExpectedConditions.numberOfElementsToBe(by, expectedAmount));
    }

    protected void moveToElement(WebElement element) {
        actionBuilder.moveToElement(element).perform();
    }

    protected WebElement getRandomElement(List<WebElement> elements){
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }
}