package CertificateRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileBrowser {
    WebDriver driver;

    @BeforeClass
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void start() throws InterruptedException, AWTException {
        driver.navigate().to("https://gasf.vavs.vodafone.com/user/login");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.id("off-canvas"));


        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("edit-name"));
                username.sendKeys("l2_manual");
        WebElement password = driver.findElement(By.id("edit-pass"));
        password.sendKeys("Gasf123!");
        WebElement submit = driver.findElement(By.id("edit-submit"));
        submit.click();

        driver.navigate().to("https://gasf.vavs.vodafone.com/elfinder#elf_l1_Y2VydHM");

        // code using Robotclass for file upload
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);






    }

}
