package com.trello;

import com.trello.api.rest.service.TrelloApiService;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import support.ApplicationUrlUtils;
import support.SetUp;


public class BaseTest {
    /**
     * Webdriver setup option
     */
    private WebDriver driver;
    /**
     * API service for api testing
     * Go into the class and see what is in
     */
    public TrelloApiService trelloApiService = new TrelloApiService();
    public LoginPage loginPage = new LoginPage();

    /**
     * Method which execute before every test
     */
    @BeforeMethod
    public void readPropertiesFile() {
            driver = SetUp.createDriver();
            //driver.manage().window().maximize();
            driver.get(ApplicationUrlUtils.getBaseUrlUi());
    }

    /**
     * Method which execute after every test
     */
    @AfterMethod
    public void tearDown() {
        SetUp.quitDriver();
    }

}
