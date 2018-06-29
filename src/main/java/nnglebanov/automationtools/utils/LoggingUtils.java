package nnglebanov.automationtools.utils;

import io.qameta.allure.Attachment;
import nnglebanov.automationtools.driverfactory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Created by WE on 27.06.2018.
 */
public class LoggingUtils {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot()
    {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
