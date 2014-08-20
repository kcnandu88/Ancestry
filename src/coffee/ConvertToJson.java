package coffee;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class ConvertToJson {


	public JSONArray toJSONArray(String value) throws Exception {

        JSONArray json = new JSONArray(); //JSON array that will be returned
        String temp = null;

        try {
        	JSONObject obj = new JSONObject();
        	obj.put("products and Cost", value);
            json.put(obj); 

        } catch (Exception e) {
            e.printStackTrace();
        }

        return json; //return JSON array
	}
}
