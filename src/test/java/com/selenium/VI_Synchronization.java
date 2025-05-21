package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.resources.JsonReader;

public class VI_Synchronization {
    // 1. Implicit Wait - driver.manage().timeouts().implicitlyWait(10,
    // TimeUnit.SECONDS);
    // 2. Explicit (fluent) Wait - WebDriverWait wait = new WebDriverWait(driver,
    // Duration.ofSeconds(10));
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
    // 3. Fluent Wait - Wait<WebDriver> wait = new
    // FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
    // .ignoring(NoSuchElementException.class);
    // 4. Thread sleep - Thread.sleep(5000);
    // Note: Thread.sleep is not recommended for synchronization as it can lead to
    // flaky tests and is not a good practice in automation.
    // 5. Script Timeout

    private static final String JSON_PATH = "src\\test\\java\\com\\resources\\VI_Synchronization.json";

    private static final int TARGET_QUANTITY = 5;

    @Test
    public void testSynchronization() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        List<String> productsList = (List<String>) config.get("productsToAdd");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get((String) config.get("webPage"));
            List<WebElement> products = driver.findElements(By.className("product"));
            for (WebElement product : products) {
                List<WebElement> nameElements = product.findElements(By.cssSelector("[class*='product-name']"));
                if (!nameElements.isEmpty()) {
                    String productName = product.findElement(By.cssSelector("[class*='product-name']")).getText()
                            .split(" ")[0];
                    if (productsList.contains(productName)) {
                        setProductQuantity(product, TARGET_QUANTITY);
                        product.findElement(By.className("product-action")).click();
                    }
                }
            }
            driver.findElement(By.className("cart-icon")).click();
            driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
            driver.findElement(By.cssSelector("input.promoCode")).sendKeys((String) config.get("promoCode"));
            driver.findElement(By.className("promoBtn")).click();
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        } finally {
            driver.quit();
        }
    }

    @Test
    public void fluentWait() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap(JSON_PATH);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get((String) config.get("webPage2"));
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3))
                                                                .ignoring(NoSuchElementException.class);
        wait.until(d -> {
            WebElement result = d.findElement(By.cssSelector("[id='finish'] h4"));
            return result.getText().equalsIgnoreCase("Hello World!");
        });
        driver.quit();

    }

    private void setProductQuantity(WebElement product, int targetQuantity) {
        WebElement quantityElement = product.findElement(By.className("stepper-input"))
                .findElement(By.className("quantity"));
        while (!quantityElement.getDomAttribute("value").equalsIgnoreCase(String.valueOf(targetQuantity))) {
            product.findElement(By.className("stepper-input")).findElement(By.className("increment")).click();
        }
    }

}
