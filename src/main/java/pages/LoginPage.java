package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.ActionMethods;
import support.ApplicationUrlUtils;
import support.SetUp;
import support.WaitMethods;

import java.util.List;

import static support.ActionMethods.waitAndClick;
import static support.ActionMethods.waitAndEnterText;
import static support.WaitMethods.waitForInvisibilityOfElement;

public class LoginPage {

    private final By username = By.cssSelector("#user");
    private final By password = By.cssSelector("#password");
    private final By loginButton = By.cssSelector("#login");
    private final By loginSubmitButton = By.cssSelector("#login-submit");

    @Step("Enter username and password and click on submit button")
    public HomePage login() throws InterruptedException {
        waitAndEnterText(username, ApplicationUrlUtils.getUsername());
        waitForInvisibilityOfElement(password);
        waitAndClick(loginButton);
        waitAndEnterText(password, ApplicationUrlUtils.getPassword());
        waitAndClick(loginSubmitButton);
        Thread.sleep(5000);
        return new HomePage();
    }
}
