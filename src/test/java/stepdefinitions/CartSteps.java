package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.DriverManager;

public class CartSteps {

    CartPage cartPage = new CartPage(DriverManager.getDriver());
    @Given("Sepetim ekranının yüklendiğinin kontrolü yapılır")
    public void checkedCartPage(){
        cartPage.checkCartPage();
    }
    @When("Sepetim ekranında Sil butonuna tıklanır")
    public void deletedButton(){
        cartPage.deleteButton();
    }
    @Then("Sepetin boş olduğu kontrol edilir")
    public void checkedEmptyCart(){
        cartPage.checkEmptyCart();
    }

}
