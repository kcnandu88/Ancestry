package coffee;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class ConvertToJson {


	public JSONArray toJSONArray(String crunchifyBuilder) throws Exception {

        JSONArray json = new JSONArray(); //JSON array that will be returned
        String temp = null;

        try {
        	JSONObject obj = new JSONObject();
        	obj.put("cost", crunchifyBuilder);
            json.put(obj); 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json; //return JSON array
	}
}
