Feature: KUSUT382-01-ZZ

    @HappyPath
  	Scenario: [200] Get profile identifier - OK
  	When Use tag "kusu_kusur382_trucha" into data manager
    When Execute TRX "KUSUT382-01-ZZ_onlyMandatoryParams" con user perfilado
    Then TRX return 200 errorCode
	And TRX return "data.profileId" is NOT NULL field
       
    @MANDATORY_DOCUMENT
  	Scenario Outline: [409-KUSU01433000] Get profile identifier - no identity document
  	When Use tag "kusu_kusur382_trucha" into data manager
    When Execute TRX "KUSUT382-01-ZZ_noDocument" con user perfilado
    Then TRX return <httpStatus> errorCode
    And TRX return <errorCode> APX Error
    Examples:
      | tagName | errorCode | httpStatus |
      | "EmptyValues" | "01433000" | 409 |
	  
    @MANDATORY_CUSTOMER
  	Scenario Outline: [409-KUSU01433000] Get profile identifier - no customer
  	When Use tag "kusu_kusur382_trucha" into data manager
    When Execute TRX "KUSUT382-01-ZZ_noCustomer" con user perfilado
    Then TRX return <httpStatus> errorCode
    And TRX return <errorCode> APX Error
    Examples:
      | tagName | errorCode | httpStatus |
      | "EmptyValues" | "01433000" | 409 |
	  
    @PROFILE_NOT_FOUND
  	Scenario Outline: [409-KUSU01433002] Get profile identifier - profile not found
  	When Use tag "kusu_kusur382_trucha" into data manager
    When Execute TRX "KUSUT382-01-ZZ_profileNotFound" con user perfilado
    Then TRX return <httpStatus> errorCode
    And TRX return <errorCode> APX Error
    Examples:
      | tagName | errorCode | httpStatus |
      | "EmptyValues" | "01433002" | 409 |
