import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class httpPatchRequest {
    @Test
    public void patchRequest() {
        JSONObject patchrequset = new JSONObject();
        patchrequset.put("name", "Abena Mensah");
        patchrequset.put("job", "FullStack Developer");
        given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(patchrequset.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then().assertThat().statusCode(200).log().all();
    }
}
