package CertificateRequest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class boot {

    WebDriver driver;

    @Test

    public void Register() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.nike.com/eg");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//Collecting all the elements present in the dropdown
        List<WebElement> allDropDownValues = driver.findElements(By.xpath("//button[@class='nav-btn p0-sm body-4 u-bold ml2-sm mr2-sm']//span[@id='hf_title_signin_membership']"));

//Finding the count of all elements
        int dropDownCount = allDropDownValues.size();

//Printing count of all items
        System.out.println("Total items present in the dropdown : " + dropDownCount);

//For loop to go each and every element in the dropdown
        for (int i = 0; i < dropDownCount; i++) {
//if condition to check specific element "Java"
            if (allDropDownValues.get(i).getText().contains("Java")) {

//Clicking the desired element
                allDropDownValues.get(i).click();
//Stop continuing the loop as we already found the desired element
                break;
            }
        }
    }
}
