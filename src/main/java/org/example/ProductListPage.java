package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public List<WebElement> products;
    public String prodName;
    public ProductListPage(WebDriver driver) {

        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Bekleme süresini belirleyebilirsiniz

    }


    public void applySorting(String arg0) throws InterruptedException{

        WebElement dropdownElement = driver.findElement(By.cssSelector(".sort select"));

        // Select sınıfını kullanarak dropdown menüsünü kontrol et
        Select dropdown = new Select(dropdownElement);
        // "Alfabetik" seçeneğini seç
        String name="Alfabetik";
        dropdown.selectByVisibleText(name);
    }


    public void applyFilter(String arg0) {
        // stok kontrolü
        if(arg0.equals("Stokta")){
        WebElement inStockCheckbox = driver.findElement(By.xpath("//label[input[@name='selected_in_shelf' and @value='1']]"));
        inStockCheckbox.click();}
    }


    public void goToPage() {
        // 2. sayfaya gitme
        WebElement pageLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='2']")));
        pageLink.click();

    }


    public void selectProduct() throws InterruptedException {
        // Üçüncü ürünü seç

         products = driver.findElements(By.className("product-cr"));


        if (products.size() >= 3) {
            WebElement thirdProduct = products.get(3);

            // Ürünün adını almak
            WebElement productNameElement = thirdProduct.findElement(By.className("name"));
            prodName = productNameElement.getText();
            WebElement productLink = thirdProduct.findElement(By.className("pr-img-link"));
            productLink.click();
            System.out.println("Ürüne tıklandı, detay sayfasına gidiliyor.");

            // Sayfanın yüklenmesini beklemek için kısa bir süre bekleyebilirsiniz
            Thread.sleep(2000); // 2 saniye bekleyin (isteğe bağlı, sayfanın yüklenmesini beklemek için)
            System.out.println("ürün açıldı");
        } else {
            System.out.println("3. ürün bulunamadı.");
        }
    }
}
