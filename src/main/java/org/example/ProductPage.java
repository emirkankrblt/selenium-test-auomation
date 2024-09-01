package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String prodName;
    public ProductPage(WebDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1)); // Bekleme süresini belirleyebilirsiniz

    }

    public void getPrice() {
        // Fiyat içeren <div> elementini bul
        WebElement priceElement = driver.findElement(By.cssSelector(".price__item"));

        // Fiyatı içeriğini al
        String priceText = priceElement.getText();

        // Fiyatı print et
        System.out.println("Fiyat: " + priceText);
    }

    // Ürün adını almak için
    public String getProductName() {
        // Ürün adını içeren <h1> elementini bul
        WebElement productNameElement = driver.findElement(By.cssSelector(".pr_header__heading"));
        // Ürün adını print et
        System.out.println("Ürün Adı: " + prodName);
        return  productNameElement.getText();

    }

    public void addToCart() throws InterruptedException {
        // sepete ekleme
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sepete Ekle']")));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        Thread.sleep(500);
    }

    public void checkCart() {
        // sepet kontrol
        WebElement addToCartCheck = driver.findElement(By.xpath("(//a[text()='" + prodName + "'])[1]"));
        if((getProductName()).equals(addToCartCheck.getText())){
            System.out.println("doğru ürün eklendi");
        }
        else {
            System.out.println("Sepetteki ürün adı eşleşmiyor.");
        }
    }


    public void goToCart() throws InterruptedException {
        // sepete git
        WebElement pressCart = driver.findElement(By.xpath("(//h4[@class='common-sprite'])[1]"));
        pressCart.click();
        Thread.sleep(500);

        WebElement viewCart = driver.findElement(By.cssSelector("#js-cart"));
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        viewCart.click();

    }
}
