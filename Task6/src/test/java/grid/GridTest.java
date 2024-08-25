package grid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.task6.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.Platform.WIN10;

public class GridTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        var nodeUri = "http://192.168.31.149:4444/wd/hub";
        var capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("127.0.6533.120");
    capabilities.setPlatform(WIN10);

        driver = new RemoteWebDriver(new URL(nodeUri), capabilities);
    }
    @Test
    public void DropdownTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Work\\Java\\SeleniumChromeDriver\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();


        driver.get("https://oos.dmytrominochkin.cloud/#/");


        var mainPage = new MainPage(driver);
        mainPage.setupLocation();
        mainPage.changeLanguage();

        Assert.assertEquals("Top categories", mainPage.getSectionText());
        driver.quit();

    }

}
