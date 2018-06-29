package nnglebanov.automationtools.utils;

import nnglebanov.automationtools.driverfactory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DriverWaitUtils {


    public static void waitFor(WebElement element,
                               int timer)
            throws Exception {
        WebDriver driver = DriverFactory.getInstance().getDriver();
// wait for the static element to appear
        WebDriverWait exists = new WebDriverWait(driver,
                timer);
        exists.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(element)));
    }

    public static void waitFor(By by,
                               int timer)
            throws Exception {
        WebDriver driver = DriverFactory.getInstance().getDriver();
// wait for the dynamic element to appear
        WebDriverWait exists = new WebDriverWait(driver,
                timer);
// examples: By.id(id),By.name(name),By.xpath(locator),
        // By.cssSelector(css)
        exists.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfElementLocated(by)));
    }

    public static void waitForGone(By by,
                                   int timer)
            throws Exception {
        WebDriver driver = DriverFactory.getInstance().getDriver();
// wait for the dynamic element to disappear
        WebDriverWait exists = new WebDriverWait(driver,
                timer);
// examples: By.id(id),By.name(name),By.xpath(locator),
// By.cssSelector(css)
        exists.until(ExpectedConditions.refreshed(
                ExpectedConditions.invisibilityOfElementLocated(by)));
    }

    public static void waitForTitle(String title,
                               int timer)
            throws Exception {

        WebDriver driver = DriverFactory.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, timer);

        exists.until( ExpectedConditions.refreshed(ExpectedConditions.titleContains(title)) );
    }

    public static void waitForURL(String url,
                                  int timer)
            throws Exception {

        WebDriver driver = DriverFactory.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, timer);

        exists.until( ExpectedConditions.refreshed(ExpectedConditions.urlContains(url)) );
    }

    public static void waitForClickable(By by,
                                        int timer)
            throws Exception {

        WebDriver driver = DriverFactory.getInstance().getDriver();
        WebDriverWait exists = new WebDriverWait(driver, timer);

        exists.until( ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)) );
    }


    public static void click(By by) throws Exception {

        WebDriver driver = DriverFactory.getInstance().getDriver();
        WebElement element = driver.findElement(by);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

}