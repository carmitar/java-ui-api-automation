package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static support.WaitMethods.waitForElement;

public class ActionMethods {

    public static void waitAndClick(By selector) {
        waitForElement(selector);
        WebElement element = SetUp.createDriver().findElement(selector);
        element.click();
    }

    public static void waitAndEnterText(By selector, String enterText) {
        waitForElement(selector);
        WebElement element = SetUp.createDriver().findElement(selector);
        element.sendKeys(enterText);
    }

}
