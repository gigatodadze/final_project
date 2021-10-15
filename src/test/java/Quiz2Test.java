import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.file.LinkPermission;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.support.ui.Select;

public class Quiz2Test {

    public Quiz2Test() {
    }
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        WebElement startButton = driver.findElement(By.id("startStopButton"));
        startButton.click();

        while (!driver.findElement(By.className("progress-bar")).getAttribute("aria-valuenow").equals("100")){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.MILLISECONDS);
         }
        System.out.print("'100%'");

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement option1 = driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]/option[2]"));
        option1.click();

//        List<WebElement> checkboxes = driver.findElements(By.tagName("label"));
//        for (int i=0; i<checkboxes.size(); i++){
//            if(!checkboxes[i].isSelected())
//                checkbox.click();
//        }


    }
}
