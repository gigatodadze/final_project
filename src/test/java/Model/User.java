package Model;

import io.qameta.allure.Attachment;
import io.restassured.response.Response;
import org.junit.Rule;
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

    public String UsernameAndPasswordtoString() {
        // TODO Auto-generated method stub
        return "{" + "\"userName\":" + "\"" + username + "\"," + "\"password\":" + "\"" + password + "\"" + "}";
    }

    public void register() {

        String myBody = UsernameAndPasswordtoString();

        Response responseForRegistration = given()
                .header("Content-type", "application/json")
                .body(myBody)
                .post("https://bookstore.toolsqa.com/Account/v1/User")
                .then().extract().response();

    }
    @Attachment("Screenshot on failure")
    public void login(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));

        WebElement username = driver.findElement(By.id("userName"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        username.sendKeys(this.getUserName());
        password.sendKeys(this.getPassWord());
        loginButton.click();

    }

    public void delete(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete Account']")));

        WebElement deleteAccountButton = driver.findElement(By.xpath("//*[text()='Delete Account']"));
        deleteAccountButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closeSmallModal-ok")));
        WebElement okDeleteButton = driver.findElement(By.id("closeSmallModal-ok"));
        okDeleteButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();


        assert Objects.equals(alert.getText(), "User Deleted.");
        alert.dismiss();

    }
    @Attachment("Screenshot on failure")
    public void checkLogin(WebDriver driver) {

        this.login(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement error = driver.findElement(By.id("name"));

        assert Objects.equals(error.getText(), "Invalid username or password!");

    }

    public void authorized() {

        String myBody = UsernameAndPasswordtoString();

        Response responseForAuthorization = given()
                .header("Content-type", "application/json")
                .body(myBody)
                .post("https://bookstore.toolsqa.com/Account/v1/Authorized")
                .then().extract().response();

        responseForAuthorization.print();
        String responseBody = responseForAuthorization.getBody().asString();
        assert responseBody.contains("User not found!");
    }


}
