package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Bekleme süresini belirleyebilirsiniz

    }

    public void updateQuantity(int arg0) throws InterruptedException {
        //ürün adeti güncelle
        WebElement quantity = driver.findElement(By.xpath("(//input[@name='quantity'])"));
        wait.until(ExpectedConditions.elementToBeClickable(quantity));
        quantity.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        Thread.sleep(2000);
        quantity.sendKeys("2");
        Thread.sleep(2000);
        WebElement updateCart = driver.findElement(By.xpath("//i[@class='fa fa-refresh green-icon']"));
        updateCart.click();
        Thread.sleep(10000);
    }

    public void removeProduct() throws InterruptedException {
        // ürün silme
        WebElement deleteProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-times red-icon']")));
        deleteProduct.click();
        Thread.sleep(1000);
    }
}
