package theinternet.herokuapp.Pages;

import io.qameta.allure.Step;
import nnglebanov.automationtools.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage {


    @Override
    protected String getUrl() {
        return "http://the-internet.herokuapp.com/drag_and_drop";
    }

    @FindBy(css = "#column-a")
    public WebElement columnA;

    @FindBy(css = "#column-b")
    public WebElement columnB;

    @Step
    public void checkDragging()
    {
        Assert.assertEquals(columnA.findElement(By.cssSelector("header")).getText(),"A");
        Assert.assertEquals(columnB.findElement(By.cssSelector("header")).getText(),"B");
       // new Actions(driver).dragAndDrop(columnA, columnB).perform();
        new Actions(driver).clickAndHold(columnA).moveToElement(columnB).release(columnB).perform();
        Assert.assertEquals(columnA.findElement(By.cssSelector("header")).getText(),"B");
        Assert.assertEquals(columnB.findElement(By.cssSelector("header")).getText(),"A");
    }

}
