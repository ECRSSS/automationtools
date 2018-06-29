import nnglebanov.automationtools.driverfactory.DriverFactory;
import nnglebanov.automationtools.driverfactory.enums.Browsers;
import nnglebanov.automationtools.driverfactory.enums.Environment;
import nnglebanov.automationtools.logging.GeneralTestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by WE on 23.06.2018.
 */
@Listeners(GeneralTestListener.class)
public class Test1 {

    @Test
    public void seleniumServerTest() throws MalformedURLException,Exception
    {
        DriverFactory factory=DriverFactory.getInstance();
        factory.setDriver(Browsers.CHROME,"wind", Environment.LOCAL);
        WebDriver driver = factory.getDriver();
        driver.get("https://selenium2.ru/docs/webdriver.html");
    }

    @Test
    public void seleniumServerTest1() throws MalformedURLException,Exception
    {
        DriverFactory factory=DriverFactory.getInstance();
        factory.setDriver(Browsers.CHROME,"wind", Environment.LOCAL);
        WebDriver driver = factory.getDriver();
        driver.get("https://selenium2.ru/docs/webdriver.html");
    }


    @Test
    public void seleniumServerTest2() throws MalformedURLException,Exception
    {
        DriverFactory factory=DriverFactory.getInstance();
        factory.setDriver(Browsers.CHROME,"wind", Environment.LOCAL);
        WebDriver driver = factory.getDriver();
        driver.get("https://selenium2.ru/docs/webdriver.html");
    }

}
