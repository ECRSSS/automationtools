package nnglebanov.automationtools.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage<T> {

    private WebDriver driver;


    protected void setDriver(WebDriver driver)
    {
        this.driver=driver;
    }

    protected void open()
    {
        driver.get(getUrl());
    }

    private T get() {
        return (T) this;
    }

    protected abstract String getUrl();

}