import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

        // ეს ჩემი პრო მიგნება იყო მაგრამ მგონი ასე არ უნდა ვქნათ. რახან მაინცდამაინც ვებდრაივერით გვინდა დავუცდაოთ
//        while (!driver.findElement(By.className("progress-bar")).getAttribute("aria-valuenow").equals("100")){
//            driver.manage().timeouts().implicitlyWait(2, TimeUnit.MILLISECONDS);
//         }
//        System.out.print("'100%'");

        WebElement progressBar = driver.findElement(By.className("progress-bar"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeContains(progressBar, "aria-valuenow", "100"));
        System.out.println("'100%'");
        driver.quit();
    }

    @Test
    public void secondTest() {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement LanguageDropDown = driver.findElement(By.id("dropdowm-menu-1"));
        Select myLang = new Select(LanguageDropDown);
        myLang.selectByVisibleText("C#");
        String selected = myLang.getFirstSelectedOption().getText();

        if(selected.equals("C#")){
           System.out.println("Selected programming language "+ selected + " matches to C#");
        } else {
            System.out.println("Selected programming language doesn't match " + selected);
        }

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("#checkboxes input[type=checkbox]"));
        for (WebElement checkbox : checkBoxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        WebElement myRadio = driver.findElement(By.cssSelector("#radio-buttons > input[type=radio][value=yellow]"));
        myRadio.click();

        Select fruitDropdown = new Select(driver.findElement(By.id("fruit-selects")));
        List<WebElement> fruits = fruitDropdown.getOptions();
        for (WebElement fruit : fruits) {
            if (fruit.getAttribute("value").equals("orange") && !fruit.isEnabled()) {
                System.out.println(" 'Orange' option in dropdown is disabled");
            }
        }
        driver.quit();
    }
    @Test
    public void thirdTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/iframe");
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("mce_0_ifr"))); // ეს შეიძლება თქვენთან არ დასჭირდეს, ჩემთან ვერ ასწრებდა ჩატვირთვას
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
        WebElement textArea = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        textArea.clear();
        textArea.sendKeys("Here Goes");
        driver.switchTo().defaultContent();
        WebElement ButtonCen = driver.findElement(By.cssSelector("button[aria-label=\"Align center\"]"));
        ButtonCen.click();
        driver.quit();
    }
}
