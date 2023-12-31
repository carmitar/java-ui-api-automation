package support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");

    public static String generateFileName(ITestResult result){
        Date date = new Date();
        return result.getName()+ "_" + dateFormat.format(date);
    }

    public static String takeScreenshot(WebDriver driver, String filename) throws IOException {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);

        TakesScreenshot screen = (TakesScreenshot) driver;

        File src = screen.getScreenshotAs(OutputType.FILE);

        String dest = filename + ".png";

        File target = new File("target/e2e/reports/" + dest);

        FileUtils.copyFile(src, target);

        return dest;
    }
}
