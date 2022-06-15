package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetActorsStepDef {

    HttpURLConnection conn;

    @Given("The webserver is started")
    public void startWebserver() {

    }

    @When("I send the request")
    public void sendRequest() throws IOException {
        URL url = new URL("http://127.0.0.1:8888/api/v1/actors");
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
    }

    @Then("^The request returns status code (\\d+)$")
    public void responseSuccess(int response) throws IOException {
        assertEquals(response, conn.getResponseCode(), "request unsuccessful");
    }
}
