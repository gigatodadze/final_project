import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.*;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class SelenideBasics2Test {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "chromedriver96");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();

        List<SelenideElement> books = $$(".rt-tr-group").
        filterBy(Condition.and("Publisher", Condition.text("O'Reilly Media"), Condition.text("Javascript")));
//        System.out.println(books.size());

//        ElementsCollection books =  $$(".rt-tr-group > .rt-td").filterBy(text("O'Reilly Media"));
//        System.out.println( $$(".rt-tr-group").size());
//
//        //        System.out.println(books.toString(boo.toArray()));
////        System.out.println(books.size());
////        books.forEach(
////                (ele) -> {
////                    System.out.print(ele + ",");
////                }
////        );
//
////        (byText("O'Reilly Media"));
//
////       ElementsCollection books2 =  $$(".rt-tr-group > .rt-td");
//
////        System.out.println(books);
//
////        books.addAll($$(byText("O'Reilly Media")));

//Checking sort Assertion
        SoftAssert softAssertListSize = new SoftAssert();
        open("/dynamic_controls");

        softAssertListSize.assertEquals(books.size(), 10);
        softAssertListSize.assertAll();

        driver.quit();
    }



}
