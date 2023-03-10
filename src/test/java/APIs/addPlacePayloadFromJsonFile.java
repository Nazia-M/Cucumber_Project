package APIs;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class addPlacePayloadFromJsonFile {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Salim\\Desktop\\SeleniumCucumber\\TestDataAPI\\postPayload.json"))))
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .body("scope", equalTo("APP"))  //Validate response body, scope parameter
                .header("server", "Apache/2.4.41 (Ubuntu)") //validate response body, server parameter
                .extract().response().asString();

        //JsonPath class takes String as input and converts it into Json, and helps to parsing jaon
        JsonPath js = new JsonPath(response);
        String place_Id = js.getString("place_id");
        System.out.println(place_Id);

    }
}
