package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WomanTshirtPage;
import utils.DriverManager;

public class WomanTshirtSteps {
    WomanTshirtPage womanTshirtPage = new WomanTshirtPage(DriverManager.getDriver());

    @Given("Tişörte ait katalog sayfasının geldiği görülür")
    public void checkedAltKatagoriPage(){
        womanTshirtPage.checkAltKatagoriPage();
    }
    @When("Beden: S seçilir")
    public void clickedSBeden(){
        womanTshirtPage.clickSBeden();
    }
    @Then("Beden: S seçildiği görülür")
    public void checkSelectedSBeden(){
        womanTshirtPage.checkSelectSBeden();
    }
    @And("listeden rasgele bir ürüne tıklanır")
    public void randomSelectedProduct(){
        womanTshirtPage.randomSelectProduct();
    }
}
