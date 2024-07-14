package org.task5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='mat-input-0']")
    WebElement locationForm;

    @FindBy(xpath = "//*[@id='mat-option-3']/span/div/span")
    WebElement cityComponent;

    @FindBy(css = "button.lang")
    WebElement buttonLanguage;

    @FindBy(css = "mat-option[value='en'")
    WebElement enButton;

    @FindBy(tagName = "h3")
    WebElement topicHeader;

    public void setupLocation(){
        this.locationForm.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cityComponent));
        this.cityComponent.click();

    }

    public void changeLanguage(){
        this.buttonLanguage.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(enButton));
        this.enButton.click();

    }

    public String getSectionText(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(topicHeader));
        return this.topicHeader.getText();

    }


}
