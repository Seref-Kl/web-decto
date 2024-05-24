Feature: Case Study

  Scenario: Defacto case study
    Given Defacto anasayfasindayim
    Then Kadın butonu oldugu kontrol edilir
    When Kadin secilir
    And Giyim alt kategorisinin üzerine gelinir
    Then Tüm alt kategorilerin geldiği gözlemlenir
    When Alt kategorilerden “Tişört” tıklanır
    Given Tişörte ait katalog sayfasının geldiği görülür
    When Beden: S seçilir
    Then Beden: S seçildiği görülür
    And listeden rasgele bir ürüne tıklanır
    Given Ürün detay ekranının yüklendiğinin kontrolü yapılır
    When Rasgele bir beden seçimi yapılır
    And Sepete Ekle butonuna tıklanır
    And Sepetim butonuna tıklanır
    Given Sepetim ekranının yüklendiğinin kontrolü yapılır
    When Sepetim ekranında Sil butonuna tıklanır
    Then Sepetin boş olduğu kontrol edilir
