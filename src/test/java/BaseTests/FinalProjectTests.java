package BaseTests;

import Model.User;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


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

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
    }

}
