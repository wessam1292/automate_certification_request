package CertificateRequest;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenShot {

    public WebDriver driver;




    @Test
    public void takescreenshotonfailure() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.amazon.com");
     WebElement searchTxt = driver.findElement(By.id("twotabsearchtextboxxxxxx"));
     searchTxt.sendKeys("selenium webdriver book");
     searchTxt.submit();
        Assert.assertTrue(driver.getTitle().contains("selenium"));

    }

    @AfterMethod

    public void takescreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            //create refrence of takesscreenshots

            TakesScreenshot ts = (TakesScreenshot)driver;   //taking screenshot from driver
            File source = ts.getScreenshotAs(OutputType.FILE);  //save screenshot to source file
            FileUtils.copyFile(source, new File("./screenshoots/" + result.getName() + ".png"));  //copying screenshoot from source to destination



        }
    }
        }









