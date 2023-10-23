package com.trello;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.trello.api.rest.service.TrelloApiService;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import support.ApplicationUrlUtils;
import support.Screenshot;
import support.SetUp;
import testrail.TestRailAPIException;
import testrail.TestRailService;

import java.io.IOException;
import java.util.Properties;

@Getter
public class BaseTest {
    /**
     * Webdriver setup option
     */
    private WebDriver driver;
    public static Properties properties;
    public ExtentReports report;
    public ExtentTest test;
    private final TestRailService testRailService;

    private final String TEST_ID_KEY = "testId";
    private boolean isRegressionTesting;
    private final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    /**
     * API service for api testing
     * Go into the class and see what is in
     */
    public TrelloApiService trelloApiService = new TrelloApiService();
//    public LoginPage loginPage = new LoginPage();

    public BaseTest() {
        testRailService = new TestRailService();
    }

    /**
     * Method which execute before every test
     */
    @BeforeMethod
    public void readPropertiesFile() throws IOException {
        loadProperties("");
    }

    public void loadProperties(String url) throws IOException {
        try {

            String reportPath = ApplicationUrlUtils.getFolderReportPath();
            report = new ExtentReports(reportPath, false);

//            driver = SetUp.createDriver();
//
//            driver.manage().window().maximize();
            this.isRegressionTesting = Boolean.parseBoolean(ApplicationUrlUtils.getRegressionTesting());
//            if (StringUtils.isBlank(url)) {
//                driver.get(ApplicationUrlUtils.getBaseUrlUi());
//            }
        } catch (Exception exc) {
            LOGGER.error("Failed to instantiate and load properties and web driver!");
            throw exc;
        }
    }

    /**
     * Method which execute after every test
     */
    @AfterMethod
    public void tearDown(ITestResult testResult, ITestContext testContext) throws IOException {
        String testId = testContext.getCurrentXmlTest().getParameter(TEST_ID_KEY);

        if (testResult.getStatus() == ITestResult.FAILURE) {

            String path = Screenshot.takeScreenshot(driver, Screenshot.generateFileName(testResult));

            String imgPath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imgPath);
        }

        if (isRegressionTesting) {
            testRailService.sendResult(testId, testResult);
        }

//        SetUp.quitDriver();
        report.endTest(test);
        report.flush();
    }

    public void setTestId(ITestContext context, String testId) {
        context.getCurrentXmlTest().addParameter(TEST_ID_KEY, testId);
    }

}
