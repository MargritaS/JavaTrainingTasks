package org.task5;

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

        var mainPage = new MainPage(driver);
        mainPage.setupLocation();
        mainPage.changeLanguage();

        Assert.assertEquals("Top categories", mainPage.getSectionText());
        driver.quit();

    }
}