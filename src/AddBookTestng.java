import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileUpload.ReusableMethod;
import fileUpload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBookTestng {
	
	@Test(dataProvider = "bookdata")
	public void AddBook(String isbn, String aisle) 
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String addResponse = given().header("Content-Type", "application/json")
				.body(payload.BookDetails(isbn, aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1= ReusableMethod.rawtojson(addResponse);
		String id = js1.get("ID");
		System.out.println(id);
		
		given().header("Content-Type", "text/plain")
		.body("{\r\n"
				+ "    \"ID\": \""+id+"\"\r\n"
				+ "}")
.when().delete("/Library/DeleteBook.php")
.then().log().all().assertThat().statusCode(200).extract().response().asString();
	}
	
	@DataProvider (name="bookdata")
	public Object[][] bookElements()
	{
		return new Object[][] {{"as", "874"}, {"wy", "647"}, {"yi","829"}};
	}
}
