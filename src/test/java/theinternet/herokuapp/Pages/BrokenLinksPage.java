package theinternet.herokuapp.Pages;

import io.qameta.allure.Step;
import nnglebanov.automationtools.base.BasePage;
import nnglebanov.automationtools.utils.DriverWaitUtils;
import nnglebanov.automationtools.utils.JavaScriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrokenLinksPage extends BasePage {

    @Override
    protected String getUrl() {
        return "http://the-internet.herokuapp.com/broken_images";
    }

    private int imagesOnPage=4;

    @Step
    public void checkImgs()
    {
        int nonbrokenLinks=0;
        List<WebElement> imageLinks=driver.findElements(By.cssSelector("img"));
        ArrayList<String> links=new ArrayList<>();

        for (WebElement e : imageLinks) {
            links.add(e.getAttribute("src"));
        }

        for(String link : links)
        {
            System.out.println(link);
            String mainTab = JavaScriptUtils.openNewWindow();

            driver.get(link);
            try
            {
                WebElement h = driver.findElement(By.cssSelector("body > img"));
            }
            catch (Exception ex)
            {
                nonbrokenLinks++;
            }
            JavaScriptUtils.closeNewWindow(mainTab);
        }
        Assert.assertEquals(nonbrokenLinks,imagesOnPage);
    }
}
