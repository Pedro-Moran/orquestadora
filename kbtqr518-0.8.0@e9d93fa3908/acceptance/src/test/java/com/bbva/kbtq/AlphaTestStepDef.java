package com.bbva.kbtq;

import java.util.UUID;

import javax.inject.Inject;

import com.bbva.arch.qe.backend.client.TestingScenario;
import com.bbva.arch.qe.backend.client.http.PostHttpRequestBuilder;
import com.bbva.kbtq.utils.Utils;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cucumber.api.java.en.When;

public class AlphaTestStepDef {

    @Inject
    TestingScenario scenario;

    private void setHeaders(PostHttpRequestBuilder post, String txName) {
        String[] trxNameSplit = txName.split("-");
        post.header("authorization-code", "0")
                .header("authorization-version", "0")
                .header("branch-code", "1128")
                .header("channel-code", "01")
                .header("client-document", "IMMB120")
                .header("client-identification-type", "6")
                .header("contact-identifier", "")
                .header("country-code", "ZZ")
                .header("currency-code", "EUR")
                .header("entity-code", "0182")
                .header("environ-code", "01")
                .header("header-name", "QP06")
                .header("ip-address", "0.0.0.0")
                .header("language-code", "es")
                .header("manager-user", "")
                .header("logical-transaction-code", trxNameSplit[0])
                .header("operation-date", "20190422")
                .header("operation-time", "171400")
                .header("operative-branch-code", "6252")
                .header("operative-entity-code", "0182")
                .header("product-code", "0001")
                .header("request-id", UUID.randomUUID().toString())
                .header("secondary-currency-code", "EUR")
                .header("service-id", "1")
                .header("subtype-code", "01")
                .header("type-code", "01")
                .header("user-code", "IMMA120")
                .header("version-code", trxNameSplit[1])
                .header("workstation-code", "0")
                .header("Content-Type", "application/json")
                .header("origin", "aaa")
                .header("agent-user", "")
                .header("mac", "");

    }

    @When("Execute TRX {string} with data {string}")
    public void executeAPXTransaction(String trxName, String body) {
        PostHttpRequestBuilder post = scenario.http().post("/APX_Runtime_Online/PGRestService");
        this.setHeaders(post, trxName);
        post.body().json().fromFile(body)
                .send();
    }

    @When("Execute TRX {string} with data {string} and {string} with value {string}")
    public void executeAPXTransactionWithAttributeValue(String trxName, String body, String attribute, String value) {

        ObjectNode jsonDataIn = Utils.modifyJson(body, attribute, value);
        PostHttpRequestBuilder post = scenario.http().post("/APX_Runtime_Online/PGRestService");
        this.setHeaders(post, trxName);
        post.body().json().content(jsonDataIn.toString()).send();
    }
}