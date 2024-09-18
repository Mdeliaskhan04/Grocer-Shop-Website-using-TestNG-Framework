package groceryShopUsingTestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class fruits {
    public static WebDriver driver;
    @BeforeMethod
    public void setup()
    {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rimon.pythonanywhere.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");
    }
    @Test
    public void apple()
    {
        WebElement button1 = driver.findElement(By.xpath("(//button[@type='submit' and contains(@class, 'btn') and contains(@class, 'text-primary')])[1]"));
        button1.click();
    }

    @Test
    public void Watermelon()
    {
        WebElement button4 = driver.findElement(By.xpath("(//button[@type='submit' and contains(@class, 'btn') and contains(@class, 'text-primary')])[4]"));
        button4.click();
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}
