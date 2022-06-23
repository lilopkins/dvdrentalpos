package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class SeleniumStepdefs {

    private FirefoxDriver driver;

    @Given("I navigate to {string}")
    public void navigate(String to) {
        driver = new FirefoxDriver();
        driver.get("http://localhost:3000/#" + to);
    }

    @When("I enter the credentials {string} {string} and press sign in")
    public void enterCredentials(String username, String password) {
        WebElement unInput = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"username\"]")));
        WebElement pwInput = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"password\"]")));
        WebElement btnSignin = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=\"submit\"]")));
        unInput.sendKeys(username);
        pwInput.sendKeys(password);
        btnSignin.click();
    }

    @Then("I am signed in as a {string}")
    public void signedInAs(String scope) {
        WebElement profile = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"#/profile\"]")));
        if (Objects.equals(scope, "staff"))
            assertTrue(profile.getText().contains("(staff)"));
    }

    @Then("An error appears showing {string}")
    public void errorAppears(String err) {
        WebElement errP = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".signin > p")));
        assertEquals(err, errP.getText());
    }

    @Then("A pageable element is visible")
    public void pageableVisible() {
        WebElement pageable = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pagable")));
        assertNotNull(pageable);
    }

    @Then("{string} is visible")
    public void elementVisible(String selector) {
        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
        assertNotNull(el);
    }

    @Then("the robot quits")
    public void quitDriver() {
        driver.quit();
    }
}
