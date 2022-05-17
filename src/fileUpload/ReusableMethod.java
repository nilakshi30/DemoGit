package fileUpload;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethod {

	public static JsonPath rawtojson(String response) 
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
	}
	public static JsonPath rawToJsonResponse(Response resp) {
		String body = resp.body().asString();
		JsonPath js1 = new JsonPath(body);
		return js1;
	}
}
