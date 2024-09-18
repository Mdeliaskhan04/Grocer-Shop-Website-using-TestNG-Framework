package groceryShopUsingTestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class homePage {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://rimon.pythonanywhere.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void shop()
    {
        WebElement shopLink = driver.findElement(By.partialLinkText("Shop"));
        shopLink.click();
    }
    @Test
    public void key()
    {
        WebElement elias=driver.findElement(By.xpath("//i[@class='fa fa-shopping-bag fa-2x']"));
        elias.click();
    }
    @Test
    public void Login()
    {
        WebElement login=driver.findElement(By.partialLinkText("Logi"));
        login.click();
        driver.navigate().refresh();
        driver.navigate().back();
    }
    @Test
    public void submit()
    {
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchInput.sendKeys("Mango");
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit Now']"));
        submitButton.click();
    }
    @AfterMethod
    public void closeBrowser()
    {
        String actualPageTitle=driver.getTitle();
        System.out.println(actualPageTitle);
        String expectedPageTitle="Grocery Shop";
        System.out.println(expectedPageTitle);
        if(actualPageTitle.equals(expectedPageTitle))
        {
            System.out.println("Passes!!");
        }
        else {
            System.out.println("Failed!!");
        }
        driver.quit();
    }
}
