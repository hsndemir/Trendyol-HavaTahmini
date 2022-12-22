@Ortak
Feature: Customer Trendyol alisveris sitesine girip, Register olmadan sepete urun ekleyebilmeli

  Scenario:US_001 TC_001 Sepete En Cok Eklenenler sayfasina gidebilmeli
    Given Kullanici trendyol sitesine gider
    When  Kullanici siteye girdiginde ana sayfayi gorur
    And   Kullanici Sepete En Cok Eklenenler butonuna basar
    Then  Kullanici acilan sayfada Sepetteki Urunler basligini gorur

  Scenario: US_001 TC_002 Urun secebilmeli ve sepete ekleyebilmeliyim
    Given Kullanici urun listesi gorur
    When  Kullanici listeden ilk urunu secer
    And   Kullanici urun sayfasina yonlenir
    And   Kullanici Sepete Ekle butonuna basar
    Then  Kullanici urunun basarili bir sekilde spete eklendigine dair mesaj alir
    And   Kullanici sepetim butonuna basar

  Scenario: US_001 TC_003 Sepetime girip, eklenen urunleri gorebilmeliyim
    Given Kullanici Sepetim ana sayfasinda sepete eklenen urun listesini gorur
    Then  Kullanici ekledigi urunu urun listesinde gorur