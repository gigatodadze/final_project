import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementsTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();

        WebElement element= driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for (int i = 0; i < 3; i++) {
            element.click();
        }
        WebElement elementDelete= driver.findElement(By.xpath("//*[@id=\"elements\"]/button[3]"));

        System.out.println(elementDelete.getText());

        WebElement elementDelete2= driver.findElement(By.cssSelector("[class^=added]:nth-child(3)"));

        System.out.println(elementDelete2.getText());

        driver.get("http://the-internet.herokuapp.com/challenging_dom");

        WebElement elementRow= driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]"));

//        System.out.println(elementRow);

        if(elementRow.getText().equals("Apeirian9")){
            System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[1]")).getText());
        }

        if(elementRow.getText().equals("Apeirian9")){
            System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]//following-sibling::td")).getText());
        }



    }
}
