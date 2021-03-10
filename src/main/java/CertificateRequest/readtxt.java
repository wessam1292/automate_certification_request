package CertificateRequest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
public class readtxt {
    WebDriver driver;
    public int trials = 0;

    String BR;

        public static void main(String[] args) throws IOException {
        String filepath = System.getProperty("user.dir") + "//txt//DukesDiary.txt";
        File FC = new File(filepath);
        FC.createNewFile();
        FileReader FR = new FileReader(filepath);
        BufferedReader BR = new BufferedReader(FR);
        String content = "";
        while ((content = BR.readLine()) != null) {
            System.out.println(content);


        }
    }

    @BeforeClass
    public void Setup() {
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

    }
    @Test(dataProvider = "userdata")
    public void Vodafone() throws InterruptedException, AWTException {
        //handling cookie

        if (trials==0)
        {
            Thread.sleep(10000);
            WebElement cookie = driver.findElement(By.id("onetrust-accept-btn-handler"));
            cookie.click();
        }
        trials++;
        // handling CSR upload
        String csrpath = System.getProperty("user.dir")+"\\CSR\\"+BR;
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
        StringSelection selection2 = new StringSelection(BR);
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

        //Coverage length
        WebElement coverage = driver.findElement(By.xpath("//a[normalize-space()='Select coverage length']"));
        coverage.click();
        WebElement year = driver.findElement(By.xpath("//div[@class='text']//div[1]"));
        year.click();
        WebElement Save = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        Save.click();


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
        driver.getTitle();
        Thread.sleep(10000);
        String str = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div")).getText();
        System.out.println(str);


    }


    @AfterClass
    public void EndTest() {

        driver.quit();

    }
}
