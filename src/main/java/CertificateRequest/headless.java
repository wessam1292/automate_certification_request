package CertificateRequest;

import static org.testng.Assert.assertTrue;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class headless {
    WebDriver driver;
    public int trials = 0;

    @BeforeClass
    public void Setup() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1600,900");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
       options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");


        options.addArguments("--proxy-server=direct://");
        options.addArguments("--proxy-bypass-list=*");
       options.addArguments("--proxy-server=");
       // options.addArguments("--screenshot=");
       // options.addArguments("--repl=");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }

    @Test
    public void start() throws InterruptedException, AWTException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.navigate().to("https://www.digicert.com/secure/requests/ssl_certificate/ssl_plus?guest_key=vjtxx9p1z5m9nvh0");
        driver.findElement(By.name("guest_requester_first_name")).sendKeys("wessam");
        driver.findElement(By.name("guest_requester_last_name")).sendKeys("Gamal");
        driver.findElement(By.name("guest_requester_email")).sendKeys("wessam.gamal1@vodafone.com");

        //handling cookie

        if (trials==0)
        {


            Thread.sleep(10000);
            WebElement cookie =  wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            cookie.click();
        }
            //trials++;
            // handling CSR upload
            String csrname = "contentdev.askonlineie.vodafone.com.csr";
            String csrpath = System.getProperty("user.dir") + "\\CSR\\" + csrname;
            WebElement Uploadcsr = driver.findElement(By.id("upload-csr-button"));
            Uploadcsr.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", Uploadcsr);



    // code using Robotclass for file upload
    Robot robot = new Robot();
    // To copy csrpath
    StringSelection selection = new StringSelection(csrpath);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

    // click on crtl + v csrpath
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

    // ctrl + c csrname
    StringSelection selection2 = new StringSelection(csrname);
    Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

    // ctrl + v csrname
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);

    //select organization


    WebElement organization =  driver.findElement(By.xpath("//*[@id=\"add_org_card\"]/div/h5/a"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        organization.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"existing_org\"]/div[2]/div[1]/div[2]/div/label/div/address/h5")).click();
        driver.findElement(By.id("add-org-btn")).click();

        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[1]/ul/li/input")).sendKeys("wessam.gamal1@vodafone.com");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[2]/ul/li/input")).sendKeys("amr.raafat@vodafone.com");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[3]/textarea")).sendKeys("Y");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[4]/textarea")).sendKeys("Y");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[5]/textarea")).sendKeys("Y");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[6]/textarea")).sendKeys("GROUP");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[7]/textarea")).sendKeys("certificate renewal");
        driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[8]/textarea")).sendKeys("Dev");



    WebElement DL = driver.findElement(By.xpath("//*[@id=\"request-form\"]/div[4]/div/div/div[9]/ul/li/input"));

        js.executeScript("arguments[0].scrollIntoView();", DL);
        DL.sendKeys("dl-tsse-enablers-gasf@vodafone.com");


        driver.findElement(By.id("tos")).click();
        Thread.sleep(10000);

        driver.findElement(By.id("submit-request-button")).click();


    // To get order number

        Thread.sleep(10000);
        WebElement str = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
        String order = str.getText();
        System.out.println(order);

        //driver.getTitle();
       // Thread.sleep(20000);
        //String str = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div")).getText();
        //System.out.println(str);

        //String str =driver.findElement(By.className("alert")).getText();
        //System.out.println(str);
      // WebElement str = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div/text()")));
        //str.getText();


   // String str =driver.findElement(By.className("alert")).getText();



        String scrfile = System.getProperty("user.dir") + "\\scrfile\\";
        File scrFile = ((TakesScreenshot) driver)
       .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("pathTOSaveFile"));
}


    }
