package BaseTests;

import Model.User;
import org.junit.Test;
import org.testng.annotations.BeforeTest;


public class FinalProjectTests extends Base {


    @Test
    public void main() {
        initialize();
        this.Test1();
        this.Test2();
    }
    @BeforeTest
    public void Test1() {

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
    @BeforeTest
    public void Test2() {

        driver.get("https://demoqa.com/books");

        var DemoqaBooks = new DemoqaBooks();

        DemoqaBooks.searchWithInput(driver);
        DemoqaBooks.search(driver);
    }

}
