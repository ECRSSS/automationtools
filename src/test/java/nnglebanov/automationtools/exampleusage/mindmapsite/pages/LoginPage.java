package nnglebanov.automationtools.exampleusage.mindmapsite.pages;

import nnglebanov.automationtools.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by WE on 23.06.2018.
 */
public class LoginPage extends BasePage {

    @FindBy(css="body > div.wrapper.medium.signin > main > section > form:nth-child(1) > input.fake-external-login")
    private WebElement loginGoogleButton;

    @FindBy(css = "#login")
    private WebElement nameInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    public void loginWithGoogle()
    {
        loginGoogleButton.click();
    }

    public void loginWithCredentials(String name,String password)
    {
        nameInput.sendKeys(name);
        passwordInput.sendKeys(password);
    }

    @Override
    protected String getUrl() {
        return "https://www.mindmeister.com/ru/account/login";
    }
}
