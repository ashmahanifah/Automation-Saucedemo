package helper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;
import static io.restassured.RestAssured.*;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders() {
        request = given()
                .header("Content Type", "application/json" )
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 9cacd99cde1899178349371cb10bc4fb1ee0c1c0d8fcb2712b6b72bbeb380b18");
    }


    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreateUser(String endpoint) {
        String name = "John Smith";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(payload.toString())
                .when()
                .post(endpoint);
    }

    public static Response postCreateUserInvalidData(String endpoint) {
        String name = "John Smith";
        String gender = "test123";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(payload.toString())
                .when()
                .post(endpoint);
    }

    public static Response postCreateUserInvalidEmail(String endpoint) {
        String name = "Nami San";
        String gender = "female";
        String email = "hihihi";
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(payload.toString())
                .when()
                .post(endpoint);
    }

    public static Response deleteUser(String endpoint, String userID) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + userID;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String userID) {
        String name = "Jane Mary";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();

        String finalEndpoint = endpoint + "/" + userID;
        return request
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(payload.toString())
                .when()
                .patch(finalEndpoint);
        //return request.when().patch(finalEndpoint);
    }
}
