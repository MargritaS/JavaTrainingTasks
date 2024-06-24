package org.task3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageDropdownTest {
        @Test
    public void DropdownTest() {
            System.setProperty("webdriver.chrome.driver", "C:\\Work\\Java\\SeleniumChromeDriver\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();
            driver.get("https://oos.dmytrominochkin.cloud/#/");
            driver.findElement(By.cssSelector("button.lang")).click();
            driver.findElement(By.cssSelector("mat-option[value='en']")).click();

            var language = driver.findElement(By.cssSelector("span.mat-select-min-line")).getText();
            Assert.assertEquals("EN", language);
            driver.quit();
    }
}
