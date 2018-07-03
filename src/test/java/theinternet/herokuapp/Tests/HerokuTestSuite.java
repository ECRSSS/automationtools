package theinternet.herokuapp.Tests;

import nnglebanov.automationtools.driverfactory.DriverFactory;
import nnglebanov.automationtools.driverfactory.enums.Browsers;
import nnglebanov.automationtools.driverfactory.enums.Environment;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import theinternet.herokuapp.Pages.*;

import java.io.IOException;

public class HerokuTestSuite
{

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) throws Exception
    {
        DriverFactory factory=DriverFactory.getInstance();
        factory.setDriver(Browsers.fromString(browser),"Windows 10",Environment.LOCAL);
    }
    @AfterMethod
    public void endTest()
    {
        DriverFactory.getInstance().closeDriver();
    }

    @Test
    public void ABPageCheckText() throws Exception
    {
        ExamplesPage epage = new ExamplesPage();
        epage.open();
        epage.abtestLink.click();
        ABPage abPage=new ABPage();
        abPage.checkHeaderText();
        abPage.checkPText();
    }
    @Test
    public void BasicAuthTestPositive() throws IOException,InterruptedException
    {
        ExamplesPage examplesPage=new ExamplesPage();
        examplesPage.open();
        BasicAuthPage basicAuthPage=new BasicAuthPage();
        basicAuthPage.startLoginScript("admin","admin");
        examplesPage.basicAuthLink.click();
        basicAuthPage.congratulationIfPass();

    }
    @Test
    public void BrokenLinks()
    {
        ExamplesPage examplesPage=new ExamplesPage();
        examplesPage.open();
        examplesPage.brokenImages.click();
        BrokenLinksPage brokenLinksPage=new BrokenLinksPage();
        brokenLinksPage.checkImgs();

    }

    @Test(enabled = false)
    public void DragAndDropTest() throws InterruptedException
    {
        ExamplesPage examplesPage=new ExamplesPage();
        examplesPage.open();
        examplesPage.dragAndDrop.click();
        DragAndDropPage dragAndDropPage=new DragAndDropPage();
        Thread.sleep(2000);
        dragAndDropPage.checkDragging();
    }

}
