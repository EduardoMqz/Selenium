package com.selenium;

import org.junit.Test;

public class VI_Synchronization {

    @Test
    public void testSynchronization() {

        // 1. Implicit Wait - driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 2. Explicit Wait - WebDriverWait wait = new WebDriverWait(driver, 10);
        //                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("elementId")));
        // 3. Fluent Wait - Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
        //                                              .ignoring(NoSuchElementException.class);
        // 4. Thread sleep - Thread.sleep(5000);
        //    Note: Thread.sleep is not recommended for synchronization as it can lead to flaky tests and is not a good practice in automation.
        // 5. Script Timeout


    }

}
