package GoogleAPIs;
import GoogleAPIsPayload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class addPlace {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        //From addPlace API - capture place_id
        //Pass place_id to updatePlace API with new address
        //getPlace to validate if new address is updated

        String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlacePayload())
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .log().all()
                .assertThat().statusCode(208)
                .body("scope", equalTo("APP"))  //Validate response body, scope parameter
                .header("server", "Apache/2.4.41 (Ubuntu)") //validate response body, server parameter
                .extract().response().asString();

        Assert.assertEquals("Add Place API Response", response);

        //JsonPath class takes String as input and converts it into Json, and helps to parsing jaon
        JsonPath js = new JsonPath(response);
        String place_Id = js.getString("place_id");



    }

}
