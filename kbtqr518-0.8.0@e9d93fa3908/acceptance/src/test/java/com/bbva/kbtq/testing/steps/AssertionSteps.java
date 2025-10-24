package com.bbva.kbtq.testing.steps;

import com.bbva.arch.qe.backend.client.TestingScenario;
import com.bbva.arch.qe.backend.client.asserts.AssertAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import javax.inject.Inject;

public class AssertionSteps {
	@Inject
	private TestingScenario scenario;

	@Then("I check that {string} is a list of size {int}")
	public void iCheckThatResponsePropertyIsEmptyList(String property, int size) {
		this.scenario.assertThat(property).hasSize(size);
	}

	@Then("Check that http code in {int} {int}")
	public void iCheckThatResponsePropertyIsEmptyListtwo(int httpStatus, int httpStatus2) {
		AssertAction assertAction = this.scenario.assertThat(":status");
		assertAction.anyOf(httpStatus, httpStatus2);
	}

	@Then("TRX return {string} is not empty")
	public void trxReturnIsNotEmpty(String s) {
		this.scenario.assertThat(s).isNot("");
		this.scenario.assertThat(s).isNot("[]");
	}

	@And("I check that {string} is empty")
	public void executeAPXTransactionWithAttributeValue(String value) {
		this.scenario.assertThat(value).is("");
	}
	
	@Then("I check that {string} is an empty list")
	public void iCheckThatResponsePropertyIsEmptyList(String property) {
		this.scenario.assertThat(property).hasSize(0);
	}
}
