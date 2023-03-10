package GoogleAPIs;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getPlace {

    public void getPlace(String expectedResponse){

        //pass place_Id and validate updated address is coming
        String getPlaceResponce = given()
        .log().all()
        .queryParam("key", "qaclick123")
        .queryParam("place_id",""+addPlace.place_Id+"")
        .when()
        .get("/maps/api/place/get/json")
        .then().assertThat().log().all().statusCode(200)
        .extract().response().asString();

        JsonPath js = new JsonPath(getPlaceResponce);
        String actualAddress = js.getString("address");
        Assert.assertEquals(actualAddress, expectedResponse);



    }
}
