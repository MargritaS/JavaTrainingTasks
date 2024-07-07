package org.task4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class LanguageDropdownTest {
    ChromeDriver driver = null;
    @Test
    public void DropdownTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\Java\\SeleniumChromeDriver\\chromedriver-win64\\chromedriver.exe");

        driver.get("https://oos.dmytrominochkin.cloud/#/");
        driver.findElement(By.xpath("//*[@id='mat-input-0']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mat-option-3']/span/div/span")));
        driver.findElement(By.xpath("//*[@id='mat-option-3']/span/div/span")).click();
        driver.findElement(By.cssSelector("button.lang")).click();
        driver.findElement(By.cssSelector("mat-option[value='en']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Top categories']")));

        var element = driver.findElement(By.tagName("h3"));
        Assert.assertEquals("Top categories", element.getText());
        driver.quit();
    }


    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        var networkOptions = new ChromiumNetworkConditions();
        networkOptions.setOffline(false);
        networkOptions.setLatency(Duration.ofMillis(150));   // (good conditions: 5)
        networkOptions.setDownloadThroughput(100 * 1024 ); // in kb/seconds  (good conditions: 10 * 1024 * 1024)
        networkOptions.setUploadThroughput(200 * 1024 ); // in kb/seconds (good conditions: 10 * 1024 * 1024)
        driver.setNetworkConditions(networkOptions);

    }


}