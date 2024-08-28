package grid;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.task6.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import static org.openqa.selenium.Platform.WIN10;

public class GridTest {

    protected WebDriver driver;
    private String filePath = "C:\\Work\\Java\\JavaTrainingTasks\\Task6\\src\\test\\resources\\TestData.xlsx";

    @BeforeTest
    public void setup() throws MalformedURLException, URISyntaxException {
        var nodeUri = "http://localhost:4444/wd/hub";
        var capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setPlatform(WIN10);
        driver = new RemoteWebDriver(new URI(nodeUri).toURL(), capabilities);
       ;
    }
    @Test
    public void DropdownTest() {
        driver.get("https://oos.dmytrominochkin.cloud/#/");
        var mainPage = new MainPage(driver);
        mainPage.setupLocation();
        mainPage.changeLanguage();

        var expectedValue = ExcelReader.searchInExcel(filePath, "DropdownTest");
        Assert.assertEquals(expectedValue, mainPage.getSectionText());
        driver.quit();

    }

}
