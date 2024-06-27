import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class httpPostRequest {
    @Test
    public void postRequest() {
        //https://reqres.in/api/users
        JSONObject postRequest = new JSONObject();
        postRequest.put("name", "Albert Hughes");
        postRequest.put("job", "Developer");
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(postRequest.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat().statusCode(201).log().all();
    }
}
