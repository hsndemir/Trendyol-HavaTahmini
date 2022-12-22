package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HavaTahminiStepDef {

    String url;
    Response response;
    String expectedSehir;
    @Given("kullanici url yi {string} ayarlar")
    public void kullaniciUrlYiAyarlar(String sehir) {
        url = "http://api.weatherapi.com/v1/current.json?key=a4ffe4d4bdba4e22aee60110222212&q="+sehir;
        expectedSehir=sehir;
    }

    @When("kullanici ilgili endpointe request gonderir")
    public void kullaniciIlgiliEndpointeRequestGonderir() {
        response = given().when().get(url);
        response.prettyPrint();
    }

    @Then("status code {int} olmali")
    public void statusCodeOlmali(int statusCode) {
        assertEquals(statusCode,response.getStatusCode());
    }

    @And("Gonderilen request ile gelen response ayni sehir olmali")
    public void gonderilenRequestIleGelenResponseAyniSehirOlmali() {
        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedSehir,jsonPath.getString("location.name"));
    }


}
