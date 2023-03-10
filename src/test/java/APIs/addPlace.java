package APIs;
import APIsPayload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//Run this class to execute addPlace -> updatePlace -> getPlace
public class addPlace {

    //addPlace API response parameter place_Id, passed as input to updatePlace API
    static String place_Id;

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(payload.AddPlacePayload())
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
         place_Id = js.getString("place_id");

        updatePlace up = new updatePlace();
        up.updatePlace_Placeid();

//        deletePlace dp = new deletePlace();
//        dp.deletePlace();

    }

}
