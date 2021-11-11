package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

public class WaitMethods {

    public static void waitForElement(By waitElement) {
        WebDriverWait wait = new WebDriverWait(SetUp.createDriver(), 1);
        wait.until(ExpectedConditions.presenceOfElementLocated(waitElement));
    }

    public static WebElement waitForVisibleElement(By waitElement) {
        WebDriverWait wait = new WebDriverWait(SetUp.createDriver(), 1);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    public static void waitForInvisibilityOfElement(By waitElement) {
        WebDriverWait wait = new WebDriverWait(SetUp.createDriver(), 1);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(waitElement));
    }
}
