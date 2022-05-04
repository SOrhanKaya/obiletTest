package stepDefinition;

import PageEvent.SearchFlightPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.ConstantVariables;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class SearchFlightStep {
    private WebDriver driver;
    SearchFlightPage searchFlightPage = new SearchFlightPage();

    @Given("^Anasayfaya Gidilir$")
    public void goToHomePage() {
        driver = Driver.getWebDriver();
        driver.get(ConstantVariables.HOMEPAGE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @When("^Uçak Bileti Tabına Tıklanır$")
    public void flightTicketClick(){
        searchFlightPage.flightButtonClick();
        searchFlightPage.closePopup();
    }
    @And("^Kalkış İli Seçilir$")
    public void selectDeparture(){
        searchFlightPage.selectDeparture();
    }

    @And("^Varış İli Seçilir$")
    public void selectDestination(){
        searchFlightPage.selectDestination();
    }

    @And("^Gidiş Tarihi Seçilir$")
    public void selectDepartureDate(){
        searchFlightPage.selectDepartureDate();
    }

    @And("^Dönüş Tarihi Seçilir$")
    public void selectReturnDate(){
        searchFlightPage.selectReturnDate();
    }

    @Then("^Uçuş Ara Butonuna Tıklanır$")
    public void flightSearch(){
        searchFlightPage.clickFlightSearch();

    }

    @And("^Rastgele Bir Gidiş Uçuşu Seçilir$")
    public void selectDepartureFlight(){
        searchFlightPage.checkFlightList();
    }

    @And("^Rastgele Bir Dönüş Uçuşu Seçilir$")
    public void selectReturnFlight(){
        searchFlightPage.checkReturnFlightList();
    }

    @And("^Ödeme Sayfasının Başarılı Bir Şekilde Açıldığı Kontrol Edilir$")
    public void checkPaymentPage(){
        searchFlightPage.checkPaymentPage();
    }

    @And("^Seçilen Uçuş Bilgileri Kontrol Edilir$")
    public void checkFlightInformation(){
        searchFlightPage.checkTicket();
        Driver.closeDriver();
    }

}
