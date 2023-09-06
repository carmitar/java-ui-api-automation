package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.ActionMethods;
import support.SetUp;
import support.WaitMethods;

import java.util.ArrayList;
import java.util.List;

import static support.WaitMethods.waitForInvisibilityOfElement;
import static support.WaitMethods.waitForVisibleElement;

public class HomePage extends Page{

    private By usernameLabel = By.cssSelector("h2");

    public String getUsernameLabelText() {
        waitForVisibleElement(usernameLabel);
        return super.getTextFromElement(usernameLabel);
    }



    public HomePage getAllTables(){
        List<WebElement> allBoards = SetUp.createDriver().findElements(By.cssSelector("[data-test-id='home-team-tab-section-60ac9951d98838460a550264'] ul"));

        for( WebElement board : allBoards){

            //System.out.println("AAAAAAAAAA " + board.getText());
            String test = board.getText();


//            System.out.println("***********************************************");
//            if (board.getText().contains("Settings")) {
//                board.click();
//                break;
//            }
        }
        return this;
    }

    public HomePage tester() {
        //Get the current window handle
        String windowHandle = SetUp.createDriver().getWindowHandle();

        //Get the list of window handles
        ArrayList<String> tabs = new ArrayList<>(SetUp.createDriver().getWindowHandles());
        System.out.println(tabs.size());
        //Use the list of window handles to switch between windows
        SetUp.createDriver().switchTo().window(tabs.get(0));

        //Switch back to original window
        SetUp.createDriver().switchTo().window(windowHandle);

        return this;
    }

}
