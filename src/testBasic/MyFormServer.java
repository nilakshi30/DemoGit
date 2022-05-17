package testBasic;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

public class MyFormServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       RestAssured.baseURI="http://localhost:8478";
       given().log().all().header("Content-Type", "multipart/form-data").pathParam("path1", 7383)
       .multiPart("text_file", new File("bw_7746.txt"))
       .when().post("/resource/{path1}")
       .then().log().all().assertThat().statusCode(200).extract().response().asString();
	}

}
