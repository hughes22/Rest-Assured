
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class httpGetRequests {
    
@Test
    public void getUses() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().statusCode(200).
                body("data[0].'email'",equalTo("michael.lawson@reqres.in"));
    }
}
