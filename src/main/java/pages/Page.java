package pages;

import org.openqa.selenium.By;
import support.WaitMethods;

public abstract class Page {

    public String getTextFromElement(By element) {
        return WaitMethods.waitForVisibleElement(element).getText();
    }

}
