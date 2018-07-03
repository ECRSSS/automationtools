package theinternet.herokuapp.Pages;

import io.qameta.allure.Step;
import nnglebanov.automationtools.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class BasicAuthPage extends BasePage {


    @FindBy(css = "#content > div > p")
    private WebElement pDomText;

    private String pText="Congratulations! You must have the proper credentials.";

    @Override
    protected String getUrl() {
        return "http://the-internet.herokuapp.com/basic_auth";
    }


    @Step
    public void startLoginScript(String name,String password) throws IOException
    {
        ProcessBuilder script=new ProcessBuilder("src/test/resources/autoitScripts/auth.exe",name,password);
        script.start();
    }
    @Step
    public void congratulationIfPass()
    {
        Assert.assertEquals(pText.trim(),pDomText.getText().trim());
    }
}
