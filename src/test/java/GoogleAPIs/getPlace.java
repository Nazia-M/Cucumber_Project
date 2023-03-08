package GoogleAPIs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getPlace {

    public void getPlace(){

        //pass place_Id and validate updated address is coming
        given()
        .log().all()
        .queryParam("key", "qaclick123")
        .queryParam("place_id",""+addPlace.place_Id+"")
        .when()
        .get("/maps/api/place/get/json")
        .then().assertThat().log().all().statusCode(200)
        .body("address", equalTo(""+updatePlace.new_address+""));
    }
}
