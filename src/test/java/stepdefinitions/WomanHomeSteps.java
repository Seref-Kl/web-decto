package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WomanHomePage;
import utils.DriverManager;


public class WomanHomeSteps {
    WomanHomePage womanHomePage = new WomanHomePage(DriverManager.getDriver());

    @And("Giyim alt kategorisinin üzerine gelinir")
    public void selectedGiyim(){
        womanHomePage.selectGiyim();
    }
    @Then("Tüm alt kategorilerin geldiği gözlemlenir")
    public void checkedAltKatagori(){
        womanHomePage.checkAltKatagori();
    }
    @When("Alt kategorilerden “Tişört” tıklanır")
    public void clickedTisort(){
        womanHomePage.clickTisort();

    }


}
