Feature: Kitap Yurdu'nda Arama Fonksiyonu

  Scenario Outline: Arama yapma
    Given Kitapyurdu acilir
    When Arama alanına <arg0> yazılır
    When Sıralama kısmında alfabetik seç
    When <arg02> olan filtresi seçilir.
    When İkinci Sayfa açılır.
    When Üçüncü sıradaki kitap seçilir.
    When Ürün detay sayfasındaki ürün fiyatı okunur
    When Ürün sepete eklenir.
    When Sepete eklendiği kontrol edilir.
    When Sepete gidilir.
    When Ürün adeti <arg03> yapılır.
    When Sepet temizlenir.
    Then site kapatılır
    Examples:
      | arg0             | arg01       | arg02    | arg03 |
      | "Sabahattin Ali" | "Alfabetik" | "Stokta" | 2     |

