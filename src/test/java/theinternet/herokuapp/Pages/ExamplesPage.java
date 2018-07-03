package theinternet.herokuapp.Pages;

import nnglebanov.automationtools.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamplesPage extends BasePage {


    @Override
    public String getUrl() {
        return "http://the-internet.herokuapp.com/";
    }

    @FindBy(css = "a[href*='/abtest']")
    public WebElement abtestLink;

    @FindBy(css = "a[href*='/basic_auth']")
    public WebElement basicAuthLink;

    @FindBy(css = "a[href*='/broken_images']")
    public WebElement brokenImages;

    @FindBy(css = "a[href*='/drag_and_drop']")
    public WebElement dragAndDrop;

}
