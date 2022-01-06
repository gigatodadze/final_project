package BaseTests;

import Model.Book;
import Model.BookList;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.stream.Collectors;

public class DemoqaBooks {

    public void searchWithInput(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));

        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("O'Reilly Media");
    }
    public void search(WebDriver driver) {

        List<WebElement> allReillyBooks = driver.findElements(By.xpath("//div[@class='rt-td' and contains(text(),'Reilly Media')]"));

        System.out.print(allReillyBooks.size());

        BookList list = RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books").jsonPath().getObject("", BookList.class);

        List<Book> booksList = list.books.stream().filter(x->x.publisher.equals("O'Reilly Media")).collect(Collectors.toList());

        System.out.print(booksList.size());

        Assert.assertEquals(booksList.size(),allReillyBooks.size());

    }


}
