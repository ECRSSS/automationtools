package nnglebanov.automationtools.utils;

import nnglebanov.automationtools.driverfactory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by WE on 26.06.2018.
 */
public class JavaScriptUtils {
    // constructor
    public JavaScriptUtils() {
    }
    /**
     * execute - generic method to execute a non-parameterized JS command
     *
     * @param command
     */
    public static void execute(String command) {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(command);
    }
    /**
     * execute - overloaded method to execute a JS command on WebElement
     *
     * @param command
     * @param element
     */
    public static void execute(String command,
                               WebElement element) {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(command, element);
    }

    public static boolean isPageReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return document.readyState")
                .equals("complete");
    }

    public static boolean isAjaxReady(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (Boolean)js.executeScript("return jQuery.active == 0");
    }
}