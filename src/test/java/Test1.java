import nnglebanov.automationtools.driverfactory.DriverFactory;
import nnglebanov.automationtools.driverfactory.enums.Browsers;
import nnglebanov.automationtools.driverfactory.enums.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by WE on 23.06.2018.
 */
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
    public void test1()
    {
        Assert.assertEquals(5,5);
    }
    @Test
    public void test2()
    {
        Assert.assertEquals(1,5);
    }
}
