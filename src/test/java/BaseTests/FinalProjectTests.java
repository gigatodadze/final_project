package BaseTests;

import Model.DemoqaBooks;
import Model.User;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class FinalProjectTests extends Base {

    @BeforeTest
    public void setup() {
        Base baseTest = new Base();
        baseTest.initialize();
        driver = getDriver();
    }

    @Test
    public void main() {
        this.setup();
//        this.Test1(driver);
        this.Test2(driver);
    }

    public void Test1(WebDriver driver) {

        driver.get("https://demoqa.com/login");

        var user = new User();
        user.setUserName("ggiga");
        user.setPassWord("MMephee1!");

        user.register();
        user.login(driver);
        user.delete(driver);
        user.checkLogin(driver);
        user.authorized();

    }

    public void Test2(WebDriver driver) {

        driver.get("https://demoqa.com/books");

        var DemoqaBooks = new DemoqaBooks();

        DemoqaBooks.searchWithInput(driver);
        DemoqaBooks.search(driver);
    }

}
