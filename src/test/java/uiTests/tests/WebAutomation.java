package uiTests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uiTests.pages.IkeaMainPage;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class WebAutomation {
    static WebDriver driver;
    /*
    1. Navigate to: https://www.ikea.com/us/en
    2. Using search bar at the top of the page - search for "sofa"
    3. On the first page of search results, pick the 1st item in the list and add it to the cart
    4. Using search bar at the top of the page - search for "table"
    5. On the first page of search results, pick the 3rd item in the list and add it to the cart
    6. Navigate to shopping cart page and validate that 2 items are added to the cart
    7. Click on "Use a discount code" link, enter random string of 15 characters as discountcode and click "Applydiscount" button
    8. Validate that "invalid coupon code" error message is displayel@gmail.com/scottforstall)
    */

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void searchForItem(){

        WebDriverWait wait = new WebDriverWait(driver,20);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Navigate to: https://www.ikea.com/us/en
        driver.navigate().to("https://www.ikea.com/us/en");
        // search for "sofa"
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("sofa"+ Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Scroll Down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)","");

        // Click Cookies Ok
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();

        // pick the 1st item in the list and add it to the cart
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Select First Item
        driver.findElement(By.xpath("//*[@id='search-results']/div[1]/a")).click();
        // Scroll Down
        js.executeScript("window.scrollBy(0,-500)","");
        // Add the first Item to Cart
        driver.findElement(By.xpath("//div[@id='onetrust-group-container']")).click();


        //driver.close();

    }


}
