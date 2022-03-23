package uiTests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Test
    public void searchForItem(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,20);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // Navigate to: https://www.ikea.com/us/en
        driver.get("https://www.ikea.com/us/en");
        // search for "sofa"
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("sofa"+ Keys.RETURN);
        // pick the 1st item in the list and add it to the cart
        WebElement firstItem= driver.findElement(By.xpath("(//*[@class='pip-aspect-ratio-image__image'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(firstItem));
        firstItem.click();


        driver.close();

    }


}
