package Commands;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.given;

import java.util.Objects;

public class User {

    private String username, password;

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getUserName() {
        return username;
    }

    public String getPassWord() {
        return password;
    }

    public void register() {

        String Body = "{" +
                "\"username\":" + "\"" + username + "\"," +
                "\"password\":" + "\"" + password + "\"" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .body(Body)
                .post("https://bookstore.toolsqa.com/Account/v1/User")
                .then()
                .extract().response();

    }

    public void login(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));

        WebElement usernameInput = driver.findElement(By.id("userName"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameInput.sendKeys(this.getUserName());
        passwordInput.sendKeys(this.getPassWord());
        loginButton.click();

    }

    public void delete(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete Account']")));

        WebElement deleteButton = driver.findElement(By.xpath("//*[text()='Delete Account']"));
        deleteButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeSmallModal-ok")));

        WebElement deleteCheckButton = driver.findElement(By.id("closeSmallModal-ok"));
        deleteCheckButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();


        assert Objects.equals(alert.getText(), "User has been Deleted.");
        alert.accept();

    }

    public void checkLogin(WebDriver driver) {

        this.login(driver);

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement error = driver.findElement(By.id("name"));

        assert Objects.equals(error.getText(), "Username or password is incorrect!");

    }

    public void authorized() {

        String Body = "{" +
                "\"userName\":" + "\"" + username + "\"," +
                "\"password\":" + "\"" + password + "\"" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .body(Body)
                .post("https://bookstore.toolsqa.com/Account/v1/Authorized")
                .then()
                .extract().response();

        response.print();
        String responseBody = response.getBody().asString();
        assert responseBody.contains("User is not found!");
    }


}
