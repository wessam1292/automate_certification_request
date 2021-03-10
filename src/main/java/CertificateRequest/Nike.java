package CertificateRequest;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Nike {
    WebDriver driver ;

    @Test

            public void Register() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/eg");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement Register = driver.findElement(By.xpath("//button[@class='nav-btn p0-sm body-4 u-bold ml2-sm mr2-sm']//span[@id='hf_title_signin_membership']"));
        Register.click();
Thread.sleep(2000);
       WebElement Email = driver.findElement(By.xpath("//*[@type='email']"));
        Thread.sleep(2000);
       Email.sendKeys("Amonessar@gmail.com");
       WebElement Pass = driver.findElement(By.xpath("//*[@type='password']"));
        Thread.sleep(3000);
       Pass.sendKeys("Black$mild1");
       WebElement login = driver.findElement(By.xpath("//*[@type='button']"));
       login.click();
        Thread.sleep(2000);
//Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Music' to perform mouse hover
        WebElement newrelease = driver.findElement(By.xpath("//*[@id=\"gen-nav-commerce-header-v2\"]/div[3]/header/div/div[1]/div[2]/nav/div[2]/ul/li[1]/a"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(newrelease).perform();
       WebElement LaunchSnekrs = (driver.findElement(By.xpath("//a[contains(@aria-label,'main-menu, New Releases , Featured , SNKRS Launch Calendar')]")));
        Thread.sleep(4000);
        LaunchSnekrs.click();
       WebElement Shoes = driver.findElement(By.xpath("//*[@href='/eg/launch/t/womens-lahar-low-wheat']"));

        //WebElement Shoes = driver.findElement(By.xpath("(//*[contains(text(), 'Air Jordan 4')])[2]"));
     Shoes.click();
     WebElement size = driver.findElement(By.xpath("//button[normalize-space()='EU 42']"));
     size.click();
    WebElement addtobag = driver.findElement(By.xpath("//button[normalize-space()='Add to Bag']"));
        Thread.sleep(3000);
    addtobag.click();


    // WebElement Size = driver.findElement(By.xpath("//button[normalize-space()='EU 42']"));
    // Size.click();



    }
}

