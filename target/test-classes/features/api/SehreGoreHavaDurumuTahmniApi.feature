@Api
Feature:Hava tahminini almak istedigi sehre gore request gonderip, response alir
  @Ortak
  Scenario: Kullanici aldigi hava tahminini API ile dogrular
    Given kullanici url yi "Manisa" ayarlar
    When  kullanici ilgili endpointe request gonderir
    Then  status code 200 olmali
    And   Gonderilen request ile gelen response ayni sehir olmali
