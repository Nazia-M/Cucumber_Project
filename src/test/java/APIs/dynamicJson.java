package APIs;
import APIsPayload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class dynamicJson {

    //Dynamic payload
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle){
        RestAssured.baseURI = "http://216.10.245.166";
        String response =
                given().log().all()
                .header("Content-Type","application/json")
                .body(payload.Addbook(isbn,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(response);
        String id = js.get("ID");
        System.out.println(id);

    }

    //Parameterize
    @DataProvider(name="BooksData")
    public Object[][] getData(){

        //Array = Collection of elements
        //Multi-dimensional array = Collection of arrays
        return new Object[][] {{"tyr","434"},{"fgf","323"}, {"jhj","54353"} };
    }
}
