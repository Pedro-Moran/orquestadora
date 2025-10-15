Feature: KUSUT408-01-ZZ

    @HappyPath
  	Scenario: [200] Visible and Operatible Flags - Request OK
  	When Use tag "kusu_kusut40801zz" into data manager
    When Execute TRX "KUSUT408-01-ZZ_Ok" con user perfilado de la kusut408
    Then TRX return 200 errorCode
	And TRX return "data.contractsVisibleOperableArray" is NOT NULL


    @MandatoryProfileId
  	Scenario Outline: [409-KUSU01433000] Visible and Operatible Flags - Mandatory profileId not informed
    When Execute TRX "KUSUT408-01-ZZ_mandatoryProfileId" con user perfilado de la kusut408
    Then TRX return <httpStatus> errorCode
    And TRX return <errorCode> APX Error
    Examples:
      | tagName | errorCode | httpStatus |
      | "EmptyValues" | "01433000" | 409 |


    @ProfileNotFound
  	Scenario Outline: [409-KUSU01433002] Visible and Operatible Flags - Profile not found
    When Execute TRX "KUSUT408-01-ZZ_profileNotFound" con user perfilado de la kusut408
    Then TRX return <httpStatus> errorCode
    And TRX return <errorCode> APX Error
    Examples:
      | tagName | errorCode | httpStatus |
      | "ProfileNotFound" | "01433002" | 409 |
