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

    @When("Execute TRX kusut324 {string} with object {string}")
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

        scenario.given("release_headers").tags("release_headers");
		scenario.given("kusu_kusut32401zz_headers").tags("kusu_kusut32401zz_headers");
		scenario.http().post("/APX_Runtime_Online/PGRestService")
		        .header("Accept","application/json")
				.header("remaining-time","25000")
				.header("type-code","01")
				.header("operative-entity-code","$release_headers.operative-entity-code")
				.header("entity-code","$release_headers.entity-code")
				.header("client-identification-type","$release_headers.client-identification-type")
				.header("channel-code","$release_headers.channel-code")
				.header("operation-date","$release_headers.operation-date")
				.header("branch-code","$release_headers.branch-code")
				.header("authorization-code","$release_headers.authorization-code")
				.header("language-code","$release_headers.language-code")
				.header("operation-time","$release_headers.operation-time")
				.header("operative-branch-code","$release_headers.operative-branch-code")
				.header("authorization-version","$release_headers.authorization-version")
				.header("request-id",UUID.randomUUID().toString())
				.header("contact-identifier","$release_headers.contact-identifier")
				.header("ip-address","$release_headers.ip-address")
				.header("secondary-currency-code","$release_headers.secondary-currency-code")
				.header("environ-code","$release_headers.environ-code")
				.header("product-code","$release_headers.product-code")
				.header("currency-code", "$release_headers.currency-code")
				.header("subtype-code", "$release_headers.subtype-code")
				.header("workstation-code","$release_headers.workstation-code")
				.header("Content-Type","$release_headers.Content-Type")
				.header("origin","$release_headers.origin")
				.header("country-code","$kusu_kusut32401zz_headers.countryCode")
				.header("service-id","$kusu_kusut32401zz_headers.serviceId")
				.header("user-code","$kusu_kusut32401zz_headers.userCode")
				.header("aap","$kusu_kusut32401zz_headers.aap")
				.header("header-name","$kusu_kusut32401zz_headers.headerName")
				.header("version-code","$kusu_kusut32401zz_headers.versionCode")
				.header("client-document","$kusu_kusut32401zz_headers.clientDocument")
				.header("manager-user","$kusu_kusut32401zz_headers.managerUser")
				.header("txclass",getTxClass("$kusu_kusut32401zz_headers.txClass"))
				.header("logical-transaction-code", trxNameSplit[0])
                .body().json()
                .set(userIdName, userIdName)
                .set(profileIdName, profileId)
                .set(contractsName, contracts)
                .set(idName, id)
                .end()
                .send();
        System.out.println("scenario in execution=" + this.scenario.toString());

    }

	private String getTxClass(String txClass){
		
		String environment = System.getProperty("application.environment");
    	
		if(environment.equals( "work-int-es")){
    		return txClass;
    	}else{
    		return null;
    	}
    }
	
    @When("I check that {string} not equals {string}")
    public void iAssertNotEquals(String response1, String response2) {
        scenario.assertThat(response1).isNot(response2);
    }

}