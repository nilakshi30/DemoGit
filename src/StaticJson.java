
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import java.nio.file.Files;

import java.nio.file.Paths;



import org.testng.annotations.Test;

import fileUpload.ReusableMethod;
import fileUpload.payload;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;



public class StaticJson {

@Test

public void addBook() throws IOException



{



RestAssured.baseURI="https://rahulshettyacademy.com";

String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\nipawar\\Documents\\Mydocs\\REST_Assured\\Section7_libraryAPI\\staticjson_addplace.json"))))
.when().post("maps/api/place/add/json")
.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
.header("Server", "Apache/2.4.18 (Ubuntu)").extract().body().asString();


/*
 * JsonPath js= ReusableMethod.rawToJsonResponse(resp);
 * 
 * String id=js.get("ID");
 * 
 * System.out.println(id);
 */

   //deleteBOok

}

public static String GenerateStringFromResource(String path) throws IOException {



    return new String(Files.readAllBytes(Paths.get(path)));



}

}

