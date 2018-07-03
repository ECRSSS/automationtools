package nnglebanov.automationtools.base;

import io.qameta.allure.Step;
import nnglebanov.automationtools.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage
{
    protected WebDriver driver;

    public BasePage()
    {
        driver=DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver,this);
    }

    @Step
    public void open() {
        driver.get(getUrl());
    }

    protected abstract String getUrl();

}

