package theinternet.herokuapp.Pages;

import io.qameta.allure.Step;
import nnglebanov.automationtools.base.BasePage;
import nnglebanov.automationtools.driverfactory.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ABPage extends BasePage {

    @FindBy(css = "#content > div > p")
    public WebElement p;

    @FindBy(css = "#content > div > h3")
    public WebElement header;

    private String headerText ="A/B Test Control";
    private String pText="Also known as split testing. This is a way in which businesses " +
            "are able to simultaneously test and learn different versions of a page to see which" +
            " text and/or functionality works best towards a desired outcome" +
            " (e.g. a user action such as a click-through).";



    @Step
    public void checkHeaderText()
    {
        String domText=header.getText();
        Assert.assertEquals(domText.trim(),headerText.trim());
    }
    @Step
    public void checkPText()
    {
        String domText=p.getText();
        Assert.assertEquals(domText.trim(),pText.trim());
    }


    @Override
    protected String getUrl() {
        return "http://the-internet.herokuapp.com/abtest";
    }


}
