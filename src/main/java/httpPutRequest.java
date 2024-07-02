import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
//Put Request
public class httpPutRequest {
    @Test
    public void PutRequest() {
        JSONObject postRequest = new JSONObject();
        postRequest.put("name", "Albert Kweku Hughes");
        postRequest.put("job", "Developer");
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON).body(postRequest.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(200).log().all();
    }
}
