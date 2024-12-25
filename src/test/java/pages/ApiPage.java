package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import java.util.List;
import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ApiPage {
    String setURL;
    Response res;
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

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList( "id");
        List<Object> name = res.jsonPath().getList( "name");
        List<Object> email = res.jsonPath().getList( "email");
        List<Object> gender = res.jsonPath().getList( "gender");
        List<Object> status = res.jsonPath().getList( "status");

        assertThat(id.getFirst()).isNotNull();
        assertThat(name.getFirst()).isNotNull();
        assertThat(email.getFirst()).isNotNull();
        assertThat(gender.getFirst()).isIn("female", "male");
        assertThat(status.getFirst()).isIn("active", "inactive");

        System.out.println(id.getFirst());
        System.out.println(name.getFirst());

    }

    public void validationResponseJsonWithJSONSchema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
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


}
