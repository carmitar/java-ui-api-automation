package pages;

import org.openqa.selenium.By;
import support.ActionMethods;
import support.WaitMethods;

import static support.WaitMethods.waitForInvisibilityOfElement;
import static support.WaitMethods.waitForVisibleElement;

public class HomePage extends Page{

    private By usernameLabel = By.cssSelector("h2");

    public String getUsernameLabelText() {
        waitForVisibleElement(usernameLabel);
        return super.getTextFromElement(usernameLabel);
    }

}
