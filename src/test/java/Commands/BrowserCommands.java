package Commands;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserCommands {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
    }
}
