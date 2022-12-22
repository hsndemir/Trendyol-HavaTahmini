package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TrendyolPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SepeteUrunEkleStepDef {
    TrendyolPage page = new TrendyolPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    @Given("Kullanici trendyol sitesine gider")
    public void kullaniciTrendyolSitesineGider() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));
        Thread.sleep(3000);
        page.anaSayfaGelenEkraniKapat.click();
        Driver.getDriver().manage().deleteAllCookies();
        wait.until(ExpectedConditions.visibilityOf(page.sepeteEnCokEklenenlerButton));
    }

    @When("Kullanici siteye girdiginde ana sayfayi gorur")
    public void kullaniciSiteyeGirdigindeAnaSayfayiGorur() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle = "En Trend Ürünler";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @And("Kullanici Sepete En Cok Eklenenler butonuna basar")
    public void kullaniciSepeteEnCokEklenenlerButonunaBasar() {
        page.sepeteEnCokEklenenlerButton.click();
    }

    @Then("Kullanici acilan sayfada Sepetteki Urunler basligini gorur")
    public void kullaniciAcilanSayfadaSepettekiUrunlerBasliginiGorur() {
        wait.until(ExpectedConditions.visibilityOf(page.sepeteEnCokEklenenlerPageTitle));
        Assert.assertTrue(page.sepeteEnCokEklenenlerPageTitle.isDisplayed());
    }

    @Given("Kullanici urun listesi gorur")
    public void kullaniciUrunListesiGorur() {
        int productListSize = page.sepeteEnCokEklenenlerPageList.size();
        Assert.assertNotEquals(0,productListSize);
    }

    @When("Kullanici listeden ilk urunu secer")
    public void kullaniciListedenIlkUrunuSecer() throws InterruptedException {
        page.sepeteEnCokEklenenlerPageList.get(0).click();
        Thread.sleep(2000);
    }

    @And("Kullanici urun sayfasina yonlenir")
    public void kullaniciUrunSayfasinaYonlenir() {
        List<String> windowList = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(1));
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertNotEquals("Tüm Ürünler",actualTitle);
    }

    @And("Kullanici Sepete Ekle butonuna basar")
    public void kullaniciSepeteEkleButonunaBasar() {
        page.productPageSepeteEkleButton.click();
    }

    @Then("Kullanici urunun basarili bir sekilde spete eklendigine dair mesaj alir")
    public void kullaniciUrununBasariliBirSekildeSpeteEklendigineDairMesajAlir() {
        wait.until(ExpectedConditions.visibilityOf(page.productPageSepeteEklendiSuccessText));
        Assert.assertTrue(page.productPageSepeteEklendiSuccessText.isDisplayed());
    }

    @And("Kullanici sepetim butonuna basar")
    public void kullaniciSepetimButonunaBasar() {
        page.productPageSepetimButton.click();
    }


    @Given("Kullanici Sepetim ana sayfasinda sepete eklenen urun listesini gorur")
    public void kullaniciSepetimAnaSayfasindaSepeteEklenenUrunListesiniGorur() {
        wait.until(ExpectedConditions.visibilityOf(page.sepetimPageTitle));
        Assert.assertTrue(page.sepetimPageItem.isDisplayed());
    }

    @Then("Kullanici ekledigi urunu urun listesinde gorur")
    public void kullaniciEkledigiUrunuUrunListesindeGorur() {
        Assert.assertTrue(page.sepetimPageTitle.isDisplayed());
    }
}
