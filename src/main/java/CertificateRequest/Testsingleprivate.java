package CertificateRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;



public class Testsingleprivate {
    WebDriver driver;

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
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--proxy-server=");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);


    }
@Test
        public void begin() throws InterruptedException, AWTException {
    WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://wessam.gamal1@vodafone.com:Wess@113355@enrol.pki.vodafone.com/aspx/certificate/CertificateIssuancePkcs10View.aspx");
        Thread.sleep(20000);
  WebElement button =  new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.className("secondary-button small-link")));
  driver.findElement(By.className(("secondary-button small-link"))).click();

  WebElement proceed = new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.className("small-link")));
    driver.findElement(By.className(("small-link"))).click();

        // handling choose file
        String csrname = "contentdev.askonlineie.vodafone.com.csr";
        String csrpath = System.getProperty("user.dir")+"\\CSR\\"+csrname;
        driver.findElement(By.id("ctl00_ContentPlaceHolder2_AsyncFileUpload1")).click();


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

        WebElement ServiceDescription = driver.findElement(By.id("ctl00_ContentPlaceHolder2_CustomFieldGridView_ctl02_CustomFieldTextBox"));
        ServiceDescription.sendKeys("certificate renewal");
        WebElement LocalMarket = driver.findElement(By.id("ctl00_ContentPlaceHolder2_CustomFieldGridView_ctl03_CustomFieldTextBox"));
        LocalMarket.sendKeys("GROUP");
        WebElement RequiredContacts  = driver.findElement(By.id("ctl00_ContentPlaceHolder2_TextBoxRecipientEmail"));
        RequiredContacts.sendKeys("wessam.gamal1@vodafone.com;amr.raafat@vodafone.com;dl-tsse-enablers-gasf@vodafone.com");
        WebElement Requestbutton  = driver.findElement(By.id("ctl00_ContentPlaceHolder2_RequestButton"));
        Requestbutton.click();

    }
    @AfterClass
    public void EndTest() {
        driver.quit();
    }
}

