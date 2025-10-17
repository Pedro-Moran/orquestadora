package com.bbva.kusu;
import com.bbva.arch.qe.backend.client.TestingScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;
import java.util.UUID;

public class StepDefinitions {

    @Inject
    TestingScenario scenario;

    @When("Execute TRX {string} with object {string}")
    public void executeAPXTransaction(String trxName, String object){
        String userIdName = "userId";
        String profileIdName = "profileId";
        String contractsName = "contracts";
        String idName = "id";

        String userId = object + "." + userIdName;
        String profileId = object + "." + profileIdName;
        String contracts = object + "." + contractsName;
        String id = object + "." + idName;

        String[] trxNameSplit = trxName.split("-");

        scenario.http().post("/APX_Runtime_Online/PGRestService")
                .header("authorization-code", "1")
                .header("authorization-version", "1")
                .header("branch-code", "0182")
                .header("channel-code", "01")
                .header("client-document", "J43825110")
                .header("client-identification-type", "1")
                .header("contact-identifier", "123456780")
                .header("country-code", trxNameSplit[2])
                .header("currency-code", "EUR")
                .header("entity-code", "0182")
                .header("environ-code", "01")
                .header("header-name", "QP06")
                .header("ip-address", "127.0.0.1")
                .header("language-code", "ES")
                .header("logical-transaction-code", trxNameSplit[0])
                .header("operation-date", "20150226")
                .header("operation-time", "171400")
                .header("operative-branch-code", "4000")
                .header("operative-entity-code", "0182")
                .header("product-code", "0001")
                .header("request-id", UUID.randomUUID().toString())
                .header("secondary-currency-code", "EUR")
                .header("service-id", "SMGG20204087")
                .header("subtype-code", "01")
                .header("type-code", "01")
                .header("user-code", "userCode")
                .header("version-code", trxNameSplit[1])
                .header("workstation-code", "0")
                .header("Content-Type", "application/json")
                .header("origin", "aaa")
                .header("aap","10000157")
                .body().json()
                .set(userIdName, userIdName)
                .set(profileIdName, profileId)
                .set(contractsName, contracts)
                .set(idName, id)
                .end()
                .send();
        System.out.println("scenario in execution=" + this.scenario.toString());

    }

    @When("I check that {string} not equals {string}")
    public void iAssertNotEquals(String response1, String response2) {
        scenario.assertThat(response1).isNot(response2);
    }

}