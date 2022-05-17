package testBasic;

import org.testng.Assert;
import org.testng.annotations.Test;

import fileUpload.payload;
import io.restassured.path.json.JsonPath;

public class checkCourseTestNg {
   
	@Test
	public void checkTotal() {
	   int y=0;
	   JsonPath js = new JsonPath(payload.complexJson());
		
		//get total json array elements
		int count1= js.getInt("courses.size()");
		//Verify if Sum of all Course prices matches with Purchase Amount
		for(int i=0; i<count1; i++)
		{
				int price = js.get("courses["+i+"].price");
				int totcopies = js.get("courses["+i+"].copies");
				int totalPrice = price * totcopies;
				y= y + totalPrice;
				System.out.println("Total price : "+y);
		}
		int psamt = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(y, psamt);
	}
}
