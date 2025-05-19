package org.example.Saucedemo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AutomationTest {

    private WebDriver driver;
    @BeforeAll
    void setup(){
       driver= new EdgeDriver();

        driver.get("https://www.saucedemo.com");
    }
    @BeforeEach
    void refreshPage() {
        driver.navigate().refresh();
    }
    @ParameterizedTest
    @CsvSource({"standard_user,secret_sauce",
//                "locked_out_user, secret_sauce",
//                "problem_user, secret_sauce",
//                "performance_glitch_user, secret_sauce",
//                "error_user, secret_sauce",
//                "visual_user, secret_sauce"
              })
    @Order(1)
    void OpenSite(String user, String password) throws InterruptedException {
        WebElement usernameInput= driver.findElement(By.id("user-name"));
        WebElement passwordInput= driver.findElement(By.id("password"));

        usernameInput.sendKeys(user);
        passwordInput.sendKeys(password);

        WebElement submitBtn= driver.findElement(By.id("login-button"));
        Thread.sleep(1000);
        submitBtn.click();
        assertTrue(driver.getCurrentUrl().contains("inventory"), "Directed to inventory page");
        ;
    }
    // Sort products by price: Low to High
    @Test
    @Order(2)
    void sortProducts() throws InterruptedException {
        WebElement selector= driver.findElement(By.className("product_sort_container"));
        Select select= new Select(selector);
        select.selectByValue("lohi");
        Thread.sleep(1000);
    }
    // Add the two cheapest products to the cart
    @Test
    @Order(3)
    void AddingToCart() throws InterruptedException {
        List<WebElement> inventories= driver.findElements(By.cssSelector(".btn_inventory "));

        inventories.get(0).click();
        inventories.get(1).click();
        Thread.sleep(1000);
        assertEquals("2", driver.findElement(By.className("shopping_cart_badge")).getText(), "2 items selected");
    }
//    Go to the cart page
//    Verify that both items are listed
    @Test
    @Order(4)
    void CartPage() throws InterruptedException {
        WebElement cart= driver.findElement(By.className("shopping_cart_link"));
        cart.click();
        Thread.sleep((100));
    }
    @Test
    @Order(5)
    void Checkout() throws InterruptedException {
        WebElement ckut= driver.findElement(By.cssSelector(".checkout_button "));
        ckut.click();
        Thread.sleep(1000);
    }

    //Fill in checkout information:
    @Test
    @Order(6)
    void FillingCkutForm() throws InterruptedException {
        WebElement fname= driver.findElement(By.id("first-name"));
        WebElement lname= driver.findElement(By.id("last-name"));
        WebElement pcd= driver.findElement(By.id("postal-code"));

        fname.sendKeys("Ismail");
        lname.sendKeys("Hossain");
        pcd.sendKeys("203");
        Thread.sleep(1000);
        WebElement ctnu= driver.findElement(By.id("continue"));
        ctnu.click();
        Thread.sleep(1000);

    }
    // Clicl finish and verify thank you
    @Test
    @Order(7)
    void FinishThanYou() throws InterruptedException {
        WebElement fsh=driver.findElement(By.id("finish"));
        fsh.click();
        Thread.sleep(1000);
        WebElement tku= driver.findElement(By.className("complete-header"));
        assertEquals("Thank you for your order!", tku.getText(), "Message Done");
    }
    //Logout
    @Test
    @Order(8)
    void logout() throws InterruptedException {
        WebElement menuBtn = driver.findElement(By.id("react-burger-menu-btn"));
        menuBtn.click();
        Thread.sleep(500);
        WebElement lout= driver.findElement(By.id("logout_sidebar_link"));
        lout.click();
        Thread.sleep(1000);
    }


    @AfterAll
    void clearOut() throws InterruptedException {
        Thread.sleep(10000);
        if(driver!=null){
            driver.quit();
        }
    }


}