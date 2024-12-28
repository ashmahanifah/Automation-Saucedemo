package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.InputStream;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiPage {
    String setURL;
    Response res, res2, res3;
    String userID;


    public void prepareUrlFor(String url) {
        if (url.equals("GET_LIST_USERS")) {
            setURL = Endpoint.GET_LIST_USERS;
        } else if (url.equals("CREATE_NEW_USERS")) {
            setURL = Endpoint.CREATE_NEW_USERS;
        } else {
            System.out.println("input right url");
        }

    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());

    }

    public void validationStatusCodeIsEquals(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

//    public void validationStatusCodeForIncorrectInputIsEquals(int code_status) {
//        assertThat(res2.statusCode()).isEqualTo(code_status);
//        assertThat(res3.statusCode()).isEqualTo(code_status);
//    }

    public void validationStatusCodeForIncorrectInputIsEquals(int code_status, Response... responses) {
        for (Response response : responses) {
            assertThat(response.statusCode()).isEqualTo(code_status);
        }
    }

    public void validateErrorResponses(int code_status) {
        validationStatusCodeForIncorrectInputIsEquals(code_status, res2, res3);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");


        if (!id.isEmpty() && !name.isEmpty() && !email.isEmpty() && !gender.isEmpty() && !status.isEmpty()) {
            assertThat(id.get(0)).isNotNull();
            assertThat(name.get(0)).isNotNull();
            assertThat(email.get(0)).isNotNull();
            assertThat(gender.get(0)).isIn("female", "male");
            assertThat(status.get(0)).isIn("active", "inactive");

            System.out.println(id.get(0));
            System.out.println(name.get(0));
        } else {
            System.out.println("One or more lists are empty.");
        }
    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        InputStream schemaStream = Utility.getJSONSchemaInputStream(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schemaStream));
    }


    public void hitApiPostCreateNewUsers() {
        res = Models.postCreateUser(setURL);
        userID = res.jsonPath().getString("id");
    }

    public void validationResponseBodyPostCreateNewUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

    }

    public void hitApiPostCreateNewUsersWithInvalidInput() {
        res2 = Models.postCreateUserInvalidData(setURL);
    }

    public void hitApiDeleteUser() {
        res = Models.deleteUser(setURL, userID);
    }

    public void hitApiUpdateUser() {
        res = Models.updateUser(setURL, userID);
    }

    public void validationResponseBodyUpdateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

    }

    public void validationResponseBodyContains(String expectedMessage) {
        String responseBody = res.getBody().asString();
        System.out.println(responseBody);
        assertThat(responseBody).contains(expectedMessage);
    }

    public void validationResponseBodyForIncorrectInputContains(String messageBlank) {
        String response = res2.getBody().asString();
        System.out.println(response);
        assertThat(response).contains(messageBlank);
    }

    public void hitApiPostCreateNewUsersWithInvalidEmail() {
        res3 = Models.postCreateUserInvalidEmail(setURL);
    }

    public void validationResponseBodyForInvalidEmailContains(String isInvalid) {
        String resp = res3.getBody().asString();
        System.out.println(resp);
        assertThat(resp).contains(isInvalid);
    }


}
