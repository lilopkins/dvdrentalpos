package uk.hpkns.dvdrentalpos.cucumber;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationStepdefs {
    @Given("I navigate to {string}")
    public void iNavigateTo(String arg0) {

    }

    @And("I have the credentials")
    public void iHaveTheCredentials(DataTable dataTable) {
    }

    @When("I enter the credentials and press sign in")
    public void iEnterTheCredentialsAndPressSignIn() {
    }

    @Then("I am signed in as a {string}")
    public void iAmSignedInAsA(String arg0) {
    }

    @Then("An error appears showing {string}")
    public void anErrorAppearsShowing(String arg0) {
    }
}
