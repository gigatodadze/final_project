import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.SoftAsserts;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

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
