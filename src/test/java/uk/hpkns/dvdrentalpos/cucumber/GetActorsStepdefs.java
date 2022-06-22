package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.hpkns.dvdrentalpos.data.models.Actor;

import java.io.IOException;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Scope(SCOPE_CUCUMBER_GLUE)
public class GetActorsStepdefs {

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private int responseCode;

    private String getApiAddress() {
        return "http://localhost:" + port + "/api/v1/actors/1";
    }

    @Given("The webserver is started")
    public void startWebserver() {

    }

    @When("I send the request")
    public void sendRequest() {
        ResponseEntity<Actor> response = restTemplate.getForEntity(getApiAddress(), Actor.class);
        responseCode = response.getStatusCode().value();
    }

    @Then("The request returns status code {int}")
    public void responseSuccess(int response) throws IOException {
        assertEquals(response, responseCode, "request unsuccessful");
    }
}
