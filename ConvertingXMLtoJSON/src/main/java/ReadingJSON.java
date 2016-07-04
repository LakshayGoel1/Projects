import java.io.FileReader;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadingJSON {
	private static String file = "D:/temp.json";
	
	public static void main(String args[]){
		try{
			FileReader reader = new FileReader(file);
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
			
			String name = (String)jsonObject.get("reporter-output");
			System.out.println("Result:" +name);
			
			Object name2 = (Object)jsonObject.get("testng-results");
			System.out.println("Result:" +name2);
			
			Long name3 = (Long)jsonObject.get("passed");
			System.out.println("Result3:" +name3);
			
			Object name4 = (Object)jsonObject.get("");
			System.out.println("Result:" +name4);
			
			//For nested JSONObjects
			JSONObject childObject = (JSONObject)jsonObject.get("testng-results");
			JSONObject childObject2 = (JSONObject)childObject.get("suite");
			JSONObject childObject3 = (JSONObject)childObject2.get("test");
			JSONObject childObject4 = (JSONObject)childObject3.get("class");
			JSONObject childObject5 = (JSONObject)childObject4.get("test-method");
			System.out.println("2nd Result");
			String name5 = (String)childObject.get("reporter-output");
			System.out.println("Result:" +name5);
			
			/*Object name6 = (Object)childObject.get("testng-results");
			System.out.println("Result:" +name6);*/
		
			Long name7 = (Long)childObject.get("passed");
			System.out.println("Result3:" +name7);
			
			String name9 = (String) childObject5.get("started-at");
			System.out.println("Started at:"+name9);
			
			//Getting exception, may be that is not an array
			JSONArray jsonArray =  (JSONArray)childObject5.get("signature");
			for(int i = 0;i<jsonArray.length();i++){
				System.out.println("The data in the array:"+jsonArray.get(i)+"\n");
			}
				
			
			/*Object name8 = (Object)childObject.get("");
			System.out.println("Result:" +name8);
			*/
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
}
