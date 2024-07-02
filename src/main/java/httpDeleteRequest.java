import io.restassured.http.ContentType;
import org.testng.annotations.Test;
//Delete Request
import static io.restassured.RestAssured.given;
@Test
public class httpDeleteRequest {
    public void DeleteRequest() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .assertThat().statusCode(204).log().all();

    }
}
