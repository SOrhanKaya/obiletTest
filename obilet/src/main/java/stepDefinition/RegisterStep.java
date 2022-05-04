package stepDefinition;

import PageEvent.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import utilities.ConstantVariables;
import utilities.Driver;
import utilities.RegisterVariables;

import java.util.concurrent.TimeUnit;

public class RegisterStep {

    private WebDriver driver;
    RegisterPage registerPage = new RegisterPage();

    @Given("^Anasayfanın Açıldığı Görülür$")
    public void anasayfaninAcildigiGorulur(){
        driver = Driver.getWebDriver();
        driver.get(ConstantVariables.HOMEPAGE_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        if(!driver.getTitle().equals(RegisterVariables.HOMEPAGE_TITLE)){
            System.out.println("Anasayfa bulunamadı.");
            Driver.closeDriver();
        }

    }

    @When("^Üye Girişi Butonuna Tıklanır$")
    public void uyeGirisiButonunaTiklanir(){
        registerPage.signInClick();
    }

    @Then("^Üye Ol Butonuna Tıklanır$")
    public void uyeOlButonunaTiklanir(){
        registerPage.signUpClick();
    }

    @And("^E-posta Girilir$")
    public void ePostaGirilir(){
        registerPage.setEmailText();
    }

    @And("^Şifre Girilir$")
    public void sifreGirilir(){
        registerPage.setPasswordText();
    }

    @And("^Aydınlatma Metni Onay Kutusu Kontrol Edilir$")
    public void aydinlatmaMetniOnayKutusuKontrolEdilir(){
        registerPage.setContractCheckbox();
    }

    @Then("^Üyelik Tamamlanır$")
    public void uyelikTamamlanir(){
        registerPage.registerButtonClick();
    }

    @And("^Başarılı Üyelik Oluşturulduğu Görülür$")
    public void basariliUyelikOlusturulduguGorulur() {
        registerPage.isUserLogin();
        Driver.closeDriver();
    }
}
