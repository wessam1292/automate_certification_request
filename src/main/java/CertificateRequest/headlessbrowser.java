package CertificateRequest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class headlessbrowser {

    @Test(enabled = false)

    public void HeadlessBrowser(){

        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.digicert.com/secure/requests/ssl_certificate/ssl_plus?guest_key=vjtxx9p1z5m9nvh0");
        System.out.println("HTML Tiltle:  " +  driver.getTitle());

    }

    @Test

    public void ChromeHeadlessBrowser(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--window-size=1600,900");
        options.addArguments("--headless");
        options.addArguments("--proxy-server=direct://");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--proxy-server=");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.digicert.com/secure/requests/ssl_certificate/ssl_plus?guest_key=vjtxx9p1z5m9nvh0");
        System.out.println("HTML Tiltle" + driver.getTitle());

    }
}
