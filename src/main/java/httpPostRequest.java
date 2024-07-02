import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class httpPostRequest {
    @Test
    public void postRequest() {
        JSONObject postRequest = new JSONObject();
        postRequest.put("name", "Albert Kweku Hughes");
        postRequest.put("job", "Quality Assurance");
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(postRequest.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat().statusCode(201).log().all();
    }
    @Test
    public void registerUser() {
        JSONObject register = new JSONObject();
        register.put("email", "eve.holt@reqres.in");
        register.put("password", "pistol");
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(register.toJSONString()).
                when()
                .post("https://reqres.in/api/register")
                .then()
                .assertThat().statusCode(200).log().all();

    }
    @Test
    public void login() {
        JSONObject login = new JSONObject();
        login.put("email", "eve.holt@reqres.in");
        login.put("password", "cityslicka");
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(login.toJSONString())
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .assertThat().statusCode(200).log().all();
    }
    @Test
    public void unsuccessfulLogin() {
        JSONObject login = new JSONObject();
        login.put("email", "peter@klaven");
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(login.toJSONString())
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .assertThat().statusCode(400).log().all();
    }
    @Test
    public void unsuccessfulRegister() {
        JSONObject register = new JSONObject();
        register.put("email", "amalitech.com");
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(register.toJSONString())
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .assertThat().statusCode(400).log().all();
    }
}
