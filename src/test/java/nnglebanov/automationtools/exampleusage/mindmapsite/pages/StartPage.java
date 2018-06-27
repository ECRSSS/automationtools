package nnglebanov.automationtools.exampleusage.mindmapsite.pages;

import nnglebanov.automationtools.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by WE on 23.06.2018.
 */
public class StartPage extends BasePage {


    @FindBy(css="#responsive-menu > div:nth-child(2) > div.pr-30")
    private WebElement loginButton;

    @FindBy(css="#responsive-menu > div:nth-child(2) > div:nth-child(2)")
    private WebElement signUpButton;

    @FindBy(css="body > main > header > div > div:nth-child(2) > form > input.m-10.fake-external-login")
    private WebElement googleSignUp;

    @FindBy(css="body > main > header > div > div:nth-child(2) > a.external-login.m-10.h-hidden-tablet")
    private WebElement facebookSignUp;

    @Override
    public String getUrl()
    {
        return "https://www.mindmeister.com/ru";
    }

    public void goSignIn()
    {
        loginButton.click();
    }

}
