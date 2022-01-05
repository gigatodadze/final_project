package Model;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DemoqaBooks {

    public String checkBooks() {

        Response response = given().when().get("https://bookstore.toolsqa.com/BookStore/v1/Books");

        return response.getBody().asString();

    }


    public void searchWithInput(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));

        WebElement searchBox = driver.findElement(By.id("searchBox"));

        searchBox.sendKeys("O'Reilly Media");
    }
    public void search(WebDriver driver) {

        List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='rt-td' and contains(text(),'Reilly Media')]"));

        System.out.print(allElements.size());

        Response response = given().when().get("https://bookstore.toolsqa.com/BookStore/v1/Books");
        Object responseBody = response.getBody();
        
        System.out.print(responseBody.toString());
    }


}
