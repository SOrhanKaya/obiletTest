Feature: Register Custome Feature
  @RegisterStep
  Scenario: Üye Olma Senaryosu
    Given Anasayfanın Açıldığı Görülür
    When Üye Girişi Butonuna Tıklanır
    And Üye Ol Butonuna Tıklanır
    And E-posta Girilir
    And Şifre Girilir
    And Aydınlatma Metni Onay Kutusu Kontrol Edilir
    Then Üyelik Tamamlanır
    And Başarılı Üyelik Oluşturulduğu Görülür