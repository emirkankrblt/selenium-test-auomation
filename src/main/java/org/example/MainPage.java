package org.example;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class MainPage {

    private WebDriver driver;

    @FindBy(id = "search-input")
    private WebElement searchBox;

    @FindBy(id = "search-key-button")
    private WebElement searchButton;


    public MainPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public void searchForProduct(String productName) throws InterruptedException {

        // açılıştaki çerez penceresi kapatılır
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Reddet']")));
        rejectButton.click();
        // ürün adı arama kutusuna yazılır ve aratılır
        searchBox.clear();  // Önceden text varsa temizler
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        // fiyat kontrol
        /*
        WebElement priceNewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.price-new")));
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td.total")));

        // Değerleri metin olarak çekin
        String priceNewText = priceNewElement.getText().trim();
        String totalText =  totalElement.getText().trim();
        priceNewText = priceNewText.replace(',', '.');
        totalText = totalText.replace(',', '.');
        double priceNewValue = Double.parseDouble(priceNewText);
        double totalValue = Double.parseDouble(totalText);
        // Oranı hesaplayın
        double ratio = totalValue / priceNewValue;

        // Sonucu yazdırın
        System.out.println("Oran: " + ratio);
        */


    }



}