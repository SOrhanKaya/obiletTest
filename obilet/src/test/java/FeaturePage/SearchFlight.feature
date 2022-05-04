Feature: Search Flight Feature
  @Search
  Scenario: Uçak Bileti Arama Senaryosu
    Given Anasayfaya Gidilir
    When Uçak Bileti Tabına Tıklanır
    And Kalkış İli Seçilir
    And Varış İli Seçilir
    And Gidiş Tarihi Seçilir
    And Dönüş Tarihi Seçilir
    Then Uçuş Ara Butonuna Tıklanır
    And Rastgele Bir Gidiş Uçuşu Seçilir
    And Rastgele Bir Dönüş Uçuşu Seçilir
    And Ödeme Sayfasının Başarılı Bir Şekilde Açıldığı Kontrol Edilir
    And Seçilen Uçuş Bilgileri Kontrol Edilir
