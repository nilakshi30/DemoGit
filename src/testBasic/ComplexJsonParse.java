package testBasic;

import fileUpload.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(payload.complexJson());
		
		//get total json array elements
		int count1= js.getInt("courses.size()");
		System.out.println(count1);
		
		//get purchase amount
		int psamt = js.getInt("dashboard.purchaseAmount");
		System.out.println(psamt);	
		
		//get first course title
		String title = js.get("courses[0].title");
		System.out.println(title);
		
		//all course titles and price
		for(int i=0; i<count1; i++)
		{
			String courseTitle = js.get("courses["+i+"].title");
			System.out.println(courseTitle);
			
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		//print no of copies of RPA course
		for(int i=0; i<count1; i++)
		{
			String courseTitle = js.get("courses["+i+"].title");
			if(courseTitle.equalsIgnoreCase("RPA"))
			{
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("Copies of RPA course : "+ copies);
				break;
			}	
		}
		int y=0;
		//Verify if Sum of all Course prices matches with Purchase Amount
		for(int i=0; i<count1; i++)
		{
				int price = js.get("courses["+i+"].price");
				int totcopies = js.get("courses["+i+"].copies");
				int totalPrice = price * totcopies;
				y= y + totalPrice;
				System.out.println("Total price : "+y);
				if(psamt == y)
				{
					System.out.println("total course price match purchaseamount");
					break;
				}
		}
		System.out.println("Total price : "+y);
	}
}
