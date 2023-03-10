package GoogleAPIs;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class updatePlace {

    //Store New Address
    static String new_address;

    public static void updatePlace_Placeid() {

        new_address = "Summer walk, Africe";

        //using place_id update address
        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "      \"place_id\":\""+addPlace.place_Id+"\",\n" +
                        "      \"address\":\""+new_address+"\",\n" +
                        "      \"key\":\"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        getPlace gp = new getPlace();
        gp.getPlace(new_address);
    }
}
