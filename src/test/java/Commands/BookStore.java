package Commands;

import io.restassured.response.Response;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BookStore {

    public String checkBooks() {

        Response response = given().when().get("https://bookstore.toolsqa.com/BookStore/v1/Books");

        return response.getBody().asString();

    }

    public void search(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));

        WebElement searchBox = driver.findElement(By.id("searchBox"));

        searchBox.sendKeys("O'Reilly Media");

        var elements = driver.findElements(By.xpath("//div[@class='rt-td' and contains(text(),'Reilly Media')]"));

        var str = this.checkBooks();
        String myBook = "O'Reilly Media";

        assert elements.stream().count() == StringUtils.countMatches(str, myBook);

        System.out.print(StringUtils.countMatches(str, myBook));
        System.out.println(StringUtils.countMatches(str, myBook));
    }


}
