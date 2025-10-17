Feature: KUSUT324-01-ZZ

  @HappyPath
  Scenario: [200] List Alias and Favourite contract - All mandatory parameters
    When Use tag "kusu_kusut32401zz" into data manager
    When Execute TRX "KUSUT324-01-ZZ" with object "$testCase.testCase01"
    Then TRX return 200 errorCode
    And I check that "data" is not null
    And I check that "data.contracts[0].id" is not null
    And I check that "data.contracts[0].alias" is not null
    And I check that "data.contracts[0].isFavorite" is not null

  @HappyPath
  Scenario: [200] List Alias and Favourite contract - All parameters ok
    When Use tag "kusu_kusut32401zz" into data manager
    When Execute TRX "KUSUT324-01-ZZ" with object "$testCase.testCase02"
    Then TRX return 200 errorCode
    And I check that "data" is not null
    And I check that "data.contracts[0].id" is not null
    And I check that "data.contracts[0].alias" is not null
    And I check that "data.contracts[0].isFavorite" is not null

  @test
  Scenario: [409-KUSU01433002] List Alias and Favourite contract - Unreported parameters
    When Use tag "kusu_kusut32401zz" into data manager
    When Execute TRX "KUSUT324-01-ZZ" with object "$testCase.testCase03"
    Then TRX return 409 errorCode
    And TRX return "01433000" APX Error


  @test
  Scenario: [409-KUSU01433000] List Alias and Favourite contract - Unreported parameters
    When Use tag "kusu_kusut32401zz" into data manager
    When Execute TRX "KUSUT324-01-ZZ" with object "$testCase.testCase04"
    Then TRX return 409 errorCode
    And TRX return "01433000" APX Error

  @HappyPath
  Scenario: [200] List Alias and Favourite contract - Empty Response
    When Use tag "kusu_kusut32401zz" into data manager
    When Execute TRX "KUSUT324-01-ZZ" with object "$testCase.testCase05"
    Then TRX return 200 errorCode
    And I check that "data" is not null
