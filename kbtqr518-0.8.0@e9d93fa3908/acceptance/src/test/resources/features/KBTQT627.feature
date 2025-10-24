Feature: KBTQT627-01-ZZ

  @HAPPY_PATH
  Scenario: KBTQR518 - [200] get customer natural person type
    When Use tag "kbtq_Customer" into data manager
    When Execute TRX "KBTQT627-01-ZZ" with data "config/KBTQT627/KBTQT627-01-ZZ-Natural.json"
    Then TRX return 200 errorCode
    And I check that "data.customer" is not null
    And I check that "data.customer.status" is not null
    And I check that "data.customer.status.id" is not null
    And I check that "data.customer.personType" is not null
    And I check that "data.customer.creationDate" is not null
    And I check that "data.customer.personType.naturalPersonType" is not null
    And I check that "data.customer.personType.naturalPersonType.firstName" is not null
    And I check that "data.customer.personType.naturalPersonType.birthData.country" is not null
    And I check that "data.customer.personType.naturalPersonType.birthData.country.id" is not null
    And I check that "data.customer.personType.naturalPersonType.birthData.birthDate" is not null
    And I check that "data.customer.personType.naturalPersonType.nationalities[0].id" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0]" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].documentType" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].documentType.id" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].documentNumber" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].country" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].country.id" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].state" is not null
    And I check that "data.customer.personType.naturalPersonType.identityDocuments[0].state.id" is not null
    And I check that "data.customer.personType.naturalPersonType.gender" is not null
    And I check that "data.customer.personType.naturalPersonType.gender.id" is not null
    And I check that "data.customer.personType.naturalPersonType.personalTitle" is not null
    And I check that "data.customer.personType.naturalPersonType.personalTitle.id" is not null
    And I check that "data.customer.personType.naturalPersonType.maritalStatus" is not null
    And I check that "data.customer.personType.naturalPersonType.maritalStatus.id" is not null
    And I check that "data.customer.personType.naturalPersonType.language" is not null
    And I check that "data.customer.personType.naturalPersonType.language.id" is not null
    And I check that "data.customer.personType.naturalPersonType.language.correspondance" is not null
    And I check that "data.customer.personType.naturalPersonType.language.correspondance.id" is not null



  @HAPPY_PATH
  Scenario: KBTQR518 - [200] get customer legal person type
    When Use tag "kbtq_Customer" into data manager
    When Execute TRX "KBTQT627-01-ZZ" with data "config/KBTQT627/KBTQT627-01-ZZ-Legal.json"
    Then TRX return 200 errorCode
    And I check that "data.customer" is not null
    And I check that "data.customer.personType" is not null
    And I check that "data.customer.personType.legalPersonType" is not null

  @HAPPY_PATH
  Scenario: KBTQR518 - [200] get customer
    When Use tag "kbtq_Customer" into data manager
    When Execute TRX "KBTQT627-01-ZZ" with data "config/KBTQT627/KBTQT627-01-ZZ-Natural.json"
    Then TRX return 200 errorCode
    And I check that "data.customer" is not null
    And I check that "data.customer.personType" is not null

  @MANDATORY_PARAMETERS
  Scenario: KBTQR518 - [409-01429000] get a customer with customerId empty
    When Execute TRX "KBTQT627-01-ZZ" with data "config/KBTQT627/KBTQT627-01-ZZ-Natural.json" and "customerId" with value ""
    Then TRX return 409 errorCode
    And I check that "messages[0].code" is "01429000"
    And I check that "messages[0].type" is "ERROR"
    And I check that "data.customer" is null

  @NO_DATA_FOUND
  Scenario: KBTQR518 - [409-01429000] get a customer that not exist
    When Execute TRX "KBTQT627-01-ZZ" with data "config/KBTQT627/KBTQT627-01-ZZ-Natural.json" and "customerId" with value "NOEXISTE"
    Then TRX return 200 errorCode
    And I check that "messages[0].code" is "01429036"
    And I check that "messages[0].type" is "WARNING"