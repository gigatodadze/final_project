package BaseTests;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {

    static WebDriver driver;

    @Before
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    public static WebDriver getDriver() {
//        return driver;
//    }

}
