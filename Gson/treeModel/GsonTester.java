import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class GsonTester{
	public static void main(String[] args){
		String jsonString = 
         "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";

        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(jsonString);

        if(rootNode.isJsonObject()){
        	JsonObject details = rootNode.getAsJsonObject();
        	JsonElement nameNode = details.get("name");
        	System.out.println("name : " + nameNode.getAsString());


        	JsonElement ageNode = details.get("age");
        	System.out.println("age : " + ageNode.getAsInt());


        	JsonElement verified = details.get("verified");
        	System.out.println("verified : " + (verified.getAsBoolean() ? "Yes" : "No"));


        	JsonArrays marks = details.getAsJsonArray("marks");

        	for(int i=0;i<marks.size();i++){
        		JsonPrimitive value = marks.getAsJsonPrimitive();
        		System.out.println(value.getAsInt()+ " ");
        	}
        }
	}
}