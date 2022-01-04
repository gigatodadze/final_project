package DemoqaTests;

import Commands.BookStore;
import Commands.User;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Demoqa extends BaseTest {

    @BeforeTest
    public void setup() {
        BaseTest baseTest = new BaseTest();
        baseTest.initialize();
        driver = getDriver();
    }

    @Test
    public void main() {

        this.setup();

        this.test1(driver);

        this.test2(driver);

    }

    public void test1(WebDriver driver) {

        driver.get("https://demoqa.com/login");

        var user = new User();

        user.setUserName("giga");
        user.setPassWord("Mephee1!");

        user.register();

        user.login(driver);
        user.delete(driver);
        user.checkLogin(driver);
        user.authorized();

    }

    public void test2(WebDriver driver) {
        driver.get("https://demoqa.com/books");

        var bookStore = new BookStore();

        bookStore.search(driver);
    }

}
