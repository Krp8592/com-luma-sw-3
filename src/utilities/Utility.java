package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Jay Vaghani
 */
public class Utility extends BaseTest {
    /**
     * This method will click on element.
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method is used to verify the text displayed on the page
     */
    public void verifyText(String message, String expectedText, String actualText){
        Assert.assertEquals(message, expectedText, actualText);
    }

    /**
     * This method will send text to element.
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //*******************Alert Method**********************

    /**
     * This method will swap the control to handle alerts
     */
    public Alert alertHandling() {
        return driver.switchTo().alert();
    }

    /**
     * This method is used when the ‘Cancel’ button is clicked in the alert box.
     */
    public void dismiss() {
        alertHandling().dismiss();
    }

    /**
     * This method is used to click on the ‘OK’ button of the alert.
     */
    public void accept() {
        alertHandling().accept();
    }

    /**
     * This method is used to capture the alert message.
     */
    public String getText() {
        return alertHandling().getText();
    }

    /**
     * This method is used to send data to the alert box.
     */
    public void sendKeys(String sendText) {
        alertHandling().sendKeys(sendText);
    }

    //*************************** Select Class Methods ***************************************//
    /**
     * This method is used to select options by visible text.
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    /**
     * This method is used to select options by index number.
     */
    public void selectByIndex(By by, int index){
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * This method is used to select option by value.
     */
    public void selectByValue(By by, String value){
        new Select(driver.findElement(by)).selectByValue(value);
    }

    /**
     * This method is used to get all the available options.
     */
    public void getOptions(By by){
        new Select(driver.findElement(by)).getOptions();
    }

    public void selectByVisibleText(By by, String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public WebElement element (By by){
        return driver.findElement(by);
    }

    public Actions actions(){
        return new Actions(driver);
    }
}



