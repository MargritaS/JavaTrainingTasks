package org.task5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageDropdownTest {


    @Test
    public void DropdownTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\Java\\SeleniumChromeDriver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
       try {
           driver.get("https://oos.dmytrominochkin.cloud/#/");
           var mainPage = new MainPage(driver);
           mainPage.setupLocation();
           mainPage.changeLanguage();

           Assert.assertEquals("Top categories", mainPage.getSectionText());
       } finally {

           driver.quit();
       }


    }
}