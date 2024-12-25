package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;


public class ApiStep {
    ApiPage apiPage;

    public ApiStep(){
        this.apiPage = new ApiPage();
    }


    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);

    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String Filename) {
        apiPage.validationResponseJsonWithJSONSchema(Filename);
    }

    @And("hit api post create new users")
    public void hitApiPostCreateNewUsers() {
        apiPage.hitApiPostCreateNewUsers();

    }

    @Then("validation response body post create new users")
    public void validationResponseBodyPostCreateNewUsers() {
        apiPage.validationResponseBodyPostCreateNewUsers();
    }

    @Then("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @Then("hit api update data user")
    public void hitApiUpdateDataUser() {
        apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }
}
