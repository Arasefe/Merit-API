package uiTests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
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
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void searchForSofaAndTable(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Navigate to: https://www.ikea.com/us/en
        driver.navigate().to("https://www.ikea.com/us/en");
        // search for "sofa"
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("sofa"+ Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Scroll Down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        // Click Cookies Ok
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        // pick the 1st item in the list and add it to the cart
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Select First Item
        driver.findElement(By.xpath("//*[@id='search-results']/div[1]/a")).click();
        // Scroll Down
        js.executeScript("window.scrollBy(0,500)");
        // Add the first Item to Cart
        driver.findElement(By.xpath("//span[text()='Add to bag']")).click();
        // Select Continue to Bag
        driver.findElement(By.xpath("//a[@data-testid='go-to-cart']")).click();

        driver.navigate().refresh();

        // search for "table"
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("table"+ Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Scroll Down
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // pick the 3rd item in the list and add it to the cart
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Select First Item
        driver.findElement(By.xpath("//*[@id='search-results']/div[3]/a")).click();
        // Scroll Down
        js.executeScript("window.scrollBy(0,500)");
        // Add the third Item to Cart
        driver.findElement(By.xpath("//span[text()='Add to bag']")).click();

        // Select Continue to Bag
        driver.findElement(By.xpath("//a[@data-testid='go-to-cart']")).click();

        // Validate that 2 items are added to Cart


        // Click on Use a discount code
        driver.findElement(By.xpath("//span[text()='Use a discount code']")).click();
        // Enter the discount code
        driver.findElement(By.xpath("//input[@id='discountCode']")).sendKeys(randomStringGenerator());
        // Select Apply Discount
        driver.findElement(By.xpath("//span[text()='Apply discount']")).click();
        // Verify error message
        String actualErrorMessage = driver.findElement(By.xpath("//span[@id='discount-code__error']/span")).getText();
        String expectedErrorMessage = "You've added an invalid coupon code. Please try again.";
        Assertions.assertEquals(actualErrorMessage,expectedErrorMessage);

    }

    public String randomStringGenerator(){
        int leftLimit = 97;     // letter 'a'
        int rightLimit = 122;   // letter 'z'
        int targetStringLength = 15;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
