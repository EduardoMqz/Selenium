package com.selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.resources.JsonReader;

public class IV_WebElements {

    @Test
    public void webElementDropDown() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/IV_WebElements.json");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage"));
        WebElement ddlCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select selectCurrency = new Select(ddlCurrency);
        selectCurrency.selectByIndex(3);
        System.out.println(selectCurrency.getFirstSelectedOption().getText());
        selectCurrency.selectByContainsVisibleText("AED");
        System.out.println(selectCurrency.getFirstSelectedOption().getText());

        // passengers
        driver.findElement(By.id("divpaxinfo")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String passangers = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals("4 Adult", passangers);

        // Dynamic Dropdown a[@value='BLR'] -> a[@value='MAA']
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='BLR']")));
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='MAA']")));
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        driver.quit();
    }

    @Test
    public void webElementAutoComplete() throws IOException {
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/IV_WebElements.json");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage"));
        driver.findElement(By.id("autosuggest")).sendKeys("Ja");
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='ui-menu-item'] a")));
        List<WebElement> optionsCountry = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement webElement : optionsCountry) {
            if (webElement.getText().equalsIgnoreCase("Japan")) {
                webElement.click();
                break;
            }
        }
        driver.quit();
    }

    @Test
    public void webElementCheckBox() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/IV_WebElements.json");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage"));
        WebElement chkfamfri = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']"));
        Assert.assertFalse(chkfamfri.isSelected());
        chkfamfri.click();
        Assert.assertTrue(chkfamfri.isSelected());
        int chkNumb = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println(chkNumb);
        driver.quit();
    }

    @Test
    public void webElementCalendar() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/IV_WebElements.json");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage"));
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-month='4']/a[text()='12']")));
        driver.findElement(By.xpath("//td[@data-month='4']/a[text()='12']")).click();
        driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-month='5']/a[text()='12']")));
            driver.findElement(By.xpath("//td[@data-month='5']/a[text()='12']")).click();
        driver.quit();
    }

    @Test
    public void webElementAlerts() throws IOException{
        Map<String, Object> config = JsonReader.readJsonAsMap("src/test/java/com/resources/IV_WebElements.json");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get((String) config.get("webPage2"));
        driver.findElement(By.id("name")).sendKeys((String) config.get("name"));
        driver.findElement(By.id("alertbtn")).click();
        String alertTxt = driver.switchTo().alert().getText();
        Assert.assertTrue(alertTxt.contains((String) config.get("name")));
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys((String) config.get("name"));
        driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
        alertTxt = driver.switchTo().alert().getText();
        Assert.assertTrue(alertTxt.contains((String) config.get("name")));
        driver.switchTo().alert().dismiss();
        driver.quit();
    }
}
