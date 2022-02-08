package com.trello.e2e.tests;

import com.relevantcodes.extentreports.LogStatus;
import com.trello.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest {

    @Description("Verify that user can login to the Trello application.")
    @Test
    public void loginTest(ITestContext testContext) throws InterruptedException {
//        String loginToTrello = "2";
//        setTestId(testContext, loginToTrello);
        test = report.startTest("Verify that user can login to the Trello application.");

        HomePage homePage = loginPage
                .login();
        Thread.sleep(7000);
        Assert.assertEquals(homePage.getUsernameLabelText(), "Most popular templates");
        test.log(LogStatus.PASS, "User is logged in and username label displayed.");
    }

}
