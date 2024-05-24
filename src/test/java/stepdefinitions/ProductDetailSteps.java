package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import pages.ProductDetailPage;
import pages.WomanTshirtPage;
import utils.DriverManager;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage(DriverManager.getDriver());

    @Given("Ürün detay ekranının yüklendiğinin kontrolü yapılır")
    public void checkedDetailPage(){
        productDetailPage.checkDetailPage();
    }
    @When("Rasgele bir beden seçimi yapılır")
    public void selectedBeden(){
        productDetailPage.selectBedenRandom();
    }
    @And("Sepete Ekle butonuna tıklanır")
    public void addedToCart(){
        productDetailPage.addToCard();
    }
    @And("Sepetim butonuna tıklanır")
    public void clickedCart(){
        productDetailPage.clickCart();
    }

}
