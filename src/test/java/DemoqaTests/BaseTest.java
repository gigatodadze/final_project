package DemoqaTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {

    static WebDriver driver;

    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
