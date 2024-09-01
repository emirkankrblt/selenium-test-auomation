
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CartPage;
import org.example.MainPage;
import org.example.ProductPage;
import org.example.ProductListPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static ProductPage productPage;
    private static CartPage cartPage;
    private static ProductListPage productListPage;


    @Given("Kitapyurdu acilir")
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com");
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        productListPage = new ProductListPage(driver);
        mainPage = new MainPage(driver);
    }


    @When("Arama alanına {string} yazılır")
    public void searchForProduct(String arg0) throws InterruptedException {
        mainPage.searchForProduct(arg0);
    }

    @When("Sıralama kısmında alfabetik seç")
    public void applySorting(String arg0) {
        try {
            productListPage.applySorting(arg0);


        } catch (InterruptedException e) {
        }
    }




    @When("{string} olan filtresi seçilir.")
    public void applyFilter(String arg0) {

        productListPage.applyFilter(arg0);
    }



    @Then("site kapatılır")
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @When("İkinci Sayfa açılır.")
    public void goToPage() {
        productListPage.goToPage();
    }

    @And("Üçüncü sıradaki kitap seçilir.")
    public void selectProduct() throws InterruptedException {
        productListPage.selectProduct();
    }

    @And("Ürün detay sayfasındaki ürün fiyatı okunur")
    public void getPrice() {
        productPage.getPrice();
    }


    @Then("Ürün sepete eklenir.")
    public void addToCart() throws InterruptedException {
        productPage.addToCart();
    }


    @Then("Sepete eklendiği kontrol edilir.")
    public void checkCart() {
        productPage.checkCart();
    }

    @And("Sepete gidilir.")
    public void goToCart() throws InterruptedException {
        productPage.goToCart();
    }

    @Then("Ürün adeti {int} yapılır.")
    public void updateQuantity(int arg0) throws InterruptedException {
        cartPage.updateQuantity(arg0);
    }

    @Then("Sepet temizlenir.")
    public void removeProduct() throws InterruptedException {
        cartPage.removeProduct();
    }


}

