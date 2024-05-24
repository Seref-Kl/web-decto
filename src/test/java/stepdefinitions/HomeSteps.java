package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.DriverManager;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver());

    @Given("Defacto anasayfasindayim")
    public void onTheHomePage() {
        homePage.checkDeFactoIcon();
    }
    @Then("Kadın butonu oldugu kontrol edilir")
    public void checkedKadinButton(){
        homePage.checkKadinButton();
    }
    @When("Kadin secilir")
    public void clickedKadinButton(){
        homePage.clickKadinButton();
    }
}
