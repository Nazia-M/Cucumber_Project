package APIs;
import static io.restassured.RestAssured.given;

public class deletePlace {

    public static void deletePlace() {

        //using place_id delete address

//        String response =
                given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"place_id\":\""+addPlace.place_Id+"\",\n" +
                        "}")
                .when().delete("/maps/api/place/delete/json")
                .then().assertThat().log().all().statusCode(200);
//                .body("status", equalTo("OK"))
//                .extract().response().asString();

        getPlace gp = new getPlace();
        gp.getPlace("{\n" +
                "    \"msg\": \"Get operation failed, looks like place_id  doesn't exists\"\n" +
                "}");
    }
}
