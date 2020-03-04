package features;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class GetCharacterSteps{

    @Given("^I perform Get Operations for \"([^\"]*)\"$")
    public void iPerformGetOperationsFor(String url) throws Throwable {
    }
    @And("^I perform Get for the Character number \"([^\"]*)\"$")
    public void iPerformGetForTheCharacterNumber(Integer ch) throws Throwable {
      GetMethods.GetMethodCharacter(ch);
    }
    @Then("^I should see Character's name as \"([^\"]*)\"$")
    public void iShouldSeeCharacterSNameAs(String arg0) throws Throwable {
    }

    @Then("^I should see verify GET parameter$")
    public void iShouldSeeVerifyGETParameter() {
      GetMethods.CharacterQueryParam();
    }
}