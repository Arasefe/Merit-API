package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Driver {
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            //it will make that 2 threads cannot access this piece of code at the same time only 1 thread at the time
            synchronized (Driver.class) {
                String browser = ConfigurationReader.getProperty("browser");
                //jenkins command: test -Dcucumber.filter.tags="@smoke" -Dbrowser="chrome"
                //custom environment variables: -Dbrowser
                //-Dproperty  = then read in java System.getProperty("property")
                //if env variable was specified
                if (System.getProperty("browser") != null) {
                    //then change browser type
                    //regardless on value configuration.properties
                    System.out.println("Browser type was changed to: " + System.getProperty("browser"));
                    browser = System.getProperty("browser");
                }

                switch (browser) {
                    case "chrome" -> {
                        //driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        //System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver");
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().fullscreen();
                    }

                    case "firefox" -> {
                        //driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                        //System.setProperty("webdriver.gecko.driver", "src/test/drivers/geckodriver");
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().fullscreen();
                    }

                    case "Edge Driver" -> {
                        // System.setProperty("webdriver.edge.driver", "src/test/drivers/msedgedriver");
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new InternetExplorerDriver());
                        driverPool.get().manage().window().fullscreen();
                    }


                    default -> throw new RuntimeException("No such a browser yet!");
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
