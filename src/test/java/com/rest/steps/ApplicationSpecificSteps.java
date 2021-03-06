package com.rest.steps;

import com.rest.request.JerseyClient;
import com.rest.response.ResponseStorage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.rest.integration.LibraryCucumberTest.RULE;

public class ApplicationSpecificSteps {



    @Given("^I setup data$")
    public void I_setup_data() throws Throwable {
        // dummy step
    }

    @Then("^I start server$")
    public void I_start_server() throws Throwable {
        JerseyClient.initialize(String.format("http://localhost:%d/", RULE.getLocalPort()));
    }

    @Then("^I print json$")
    public void I_print_json() throws Throwable {
        System.out.println(ResponseStorage.response.json());
    }
}
