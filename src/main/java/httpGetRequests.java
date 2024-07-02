
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//Get Request
public class httpGetRequests {
    
@Test
    public void getUsers() {
        given().
                when().
                get("https://reqres.in/api/users?page=2").
                then().
                assertThat().statusCode(200).
                body("data[0].'email'",equalTo("michael.lawson@reqres.in")).
                body("data[2].'last_name'",equalTo("Funke")).log().all();
    }
    @Test
    public void singleUser() {
    given().
            when().
            get("https://reqres.in/api/users/2").
            then().
            assertThat().statusCode(200).
            body("data.'first_name'",equalTo("Janet")).
            log().all();
    }
    @Test
    public void notFound() {
    given().
            when().
            get("https://reqres.in/api/unknown/23").
            then().
            assertThat().statusCode(404).
            log().all();
    }
    @Test
    public void ListResource(){
    given().
            when().
            get("https://reqres.in/api/unknown").
            then().
            assertThat().statusCode(200).log().all();
    }
    @Test
    public void delayedResponse(){
    given()
            .when().get("https://reqres.in/api/users?delay=3")
            .then()
            .assertThat().statusCode(200)
            .body("data[5].'first_name'",equalTo("Tracey"))
            .body("data[3].'last_name'",equalTo("Holt"))
            .log().all();
    }
}
