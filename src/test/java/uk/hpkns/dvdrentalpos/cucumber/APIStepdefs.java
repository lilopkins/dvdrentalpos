package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;
import static org.junit.jupiter.api.Assertions.*;

@Scope(SCOPE_CUCUMBER_GLUE)
public class APIStepdefs {

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String body = null;
    private Map<String, String> headers = new HashMap<>();
    private String result = null;
    private int responseCode = 0;

    private String getUrl(String endpoint) {
        return "http://127.0.0.1:" + port + endpoint;
    }

    @Given("the JSON body: {string}")
    public void givenTheJson(String json) {
        body = json;
        headers.put("Content-Type", "application/json");
    }

    @Given("I have a valid API token")
    public void useApiToken() {
        headers.put("X-Token", "__testing_token__");
    }

    @Given("I have an invalid API token")
    public void useInvalidApiToken() {
        headers.put("X-Token", "__invalid_testing_token__");
    }

    @Given("I have an expired API token")
    public void useExpiredApiToken() {
        headers.put("X-Token", "__expired_testing_token__");
    }

    @When("the endpoint {string} is accessed with a {string} request")
    public void makeRequest(String endpoint, String method) throws IOException {
        URL url = new URL(getUrl(endpoint));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);

        headers.forEach(conn::setRequestProperty);
        headers.clear();

        if (body != null) {
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
            osw.write(body);
            osw.flush();
            osw.close();
            os.close();
            body = null;
        }
        conn.connect();

        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result2 = bis.read();
        while(result2 != -1) {
            buf.write((byte) result2);
            result2 = bis.read();
        }
        result = buf.toString();
        responseCode = conn.getResponseCode();
    }

    @Then("the response has status {int}")
    public void responseStatus(int status) {
        assertEquals(status, responseCode);
    }

    @Then("a paged list of resources is returned")
    public void pagedListReturned() {
        assertTrue(result.contains("content"));
    }

    @Then("the response matches {string}")
    public void responseMatches(String data) {
        assertEquals(data, result);
    }
}
