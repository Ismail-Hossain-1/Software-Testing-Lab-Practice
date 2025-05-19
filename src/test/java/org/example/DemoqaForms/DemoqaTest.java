package org.example.DemoqaForms;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.Option;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DemoqaTest {

    WebDriver driver ;
    WebDriverWait wait;
    JavascriptExecutor js;
    @BeforeAll
    void setup(){
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver= new EdgeDriver(options);
        driver.get("https://demoqa.com/automation-practice-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }
    @BeforeEach
    void refreshPage(){
        driver.navigate().refresh();
    }
    @Test
    void Automation() throws InterruptedException {
        WebElement fName= driver.findElement(By.id("firstName"));
        WebElement lName= driver.findElement(By.id("lastName"));
        WebElement email= driver.findElement(By.id("userEmail"));
        fName.sendKeys("Ismail");
        lName.sendKeys("Hossain");
        email.sendKeys("test@gmail.com");

        WebElement gender= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='gender-radio-1']")));
        js.executeScript("arguments[0].scrollIntoView(true)", gender);
        js.executeScript("arguments[0].click()", gender);

        WebElement mobile= driver.findElement(By.id("userNumber"));
        mobile.sendKeys("880148374384r34");


        js.executeScript("document.getElementById('dateOfBirthInput').value= '10 April 2010'");
        Thread.sleep(1000);

        WebElement subject= driver.findElement(By.id("subjectsInput"));
        WebElement hobbies= driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        subject.sendKeys("Physics");
        subject.sendKeys(Keys.ENTER);
        hobbies.click();
        WebElement uploadPic= driver.findElement(By.id("uploadPicture"));
        WebElement currentAddress= driver.findElement(By.id("currentAddress"));
        uploadPic.sendKeys("C:\\Users\\User\\Downloads\\3700.jpg");
        currentAddress.sendKeys("Sylhet");

//        WebElement stateCity= driver.findElement(By.id("react-select-3-input"));
        WebElement submitBtn= driver.findElement(By.id("submit"));
        WebElement dropdown = driver.findElement(By.id("state"));
        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
        WebElement state= driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("Haryana");
        state.sendKeys(Keys.ENTER);
        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys("Karnal");
        cityInput.sendKeys(Keys.ENTER);

        Thread.sleep(5000);

        submitBtn.click();
        Thread.sleep(1000);
    }

}