package uiTests.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class IkeaMainPage {
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    public IkeaMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchBox;


    @FindBy(xpath="//a[contains(@href,'/uppland-sofa-blekinge-white')]")
    public WebElement firstItem;





    public void searchForItem(String item){
        Driver.getDriver().get("https://www.ikea.com/us/en");
        searchBox.sendKeys(item+ Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(firstItem));
    }


    public void addingItemToCart(String item){
        Driver.getDriver().get("https://www.ikea.com/us/en");
        searchBox.sendKeys(item);
    }
}
