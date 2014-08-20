package coffee;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import Features.Liveliness;
import Features.Size;
import coffeename.*;

@Path("/cost/")
public class df {

	static String CoffeeType = null;
	static String Liveliness = null;
	static String Size = null;

	@GET
	@Path("/Product")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response products() throws Exception {
		Response rb = null;
		ConvertToJson convert = new ConvertToJson();
		JSONArray json = new JSONArray();
		json = convert.toJSONArray("Cappucino, Latte, Frappe, Expresso, Mocha");
		String re = null;
		re = json.toString();
		rb = Response.ok(json).build();
		return rb;
	}

	@POST
	@Path("/order")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED,
			MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public Response ProductOrder(InputStream incomingData) throws Exception {
		String input = convertStreamToString(incomingData);
		JSONObject json = new JSONObject(input);

		JSONArray jsonArray = json.getJSONArray("coffeedetails");
		for (int i = 0; i < jsonArray.length(); i++) {
			CoffeeType = jsonArray.getJSONObject(i).getString("type");
			Liveliness = jsonArray.getJSONObject(i).getString("liveliness");
			Size = jsonArray.getJSONObject(i).getString("size");
		}
		ConvertToJson convert = new ConvertToJson();

		String re = null;
		re = json.toString();
		Response rb = Response.ok(json).build();

		return rb;
	}

	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	@GET
	@Path("/h")
	@Produces(MediaType.APPLICATION_JSON)
	public Response CoffeeProducts() throws Exception {
		Response rb = null;
		ConvertToJson convert = new ConvertToJson();
		JSONArray json = new JSONArray();

		String value = null;
		double price1 = price(CoffeeType, Size, Liveliness);

		value = Double.toString(price1);
		try {
			json = convert.toJSONArray(value);
		} catch (Exception e) {
		}

		String re = null;
		re = json.toString();
		rb = Response.ok(json).build();
		return rb;

	}

	public double price(String c, String s, String l) {
		Coffee beverage2 = null;
		if (CoffeeType.equals("Mocha")) {

			beverage2 = new Mocha();
		} else if (CoffeeType.equals("Frappe")) {

			beverage2 = new Frappe();
		} else if (CoffeeType.equals("Cappucino"))
			beverage2 = new Cappucino();
		else if (CoffeeType.equals("Latte")) {
			beverage2 = new Latte();
		} else {
			beverage2 = new Expresso();
		}

		beverage2.setLiveliness(Liveliness);
		beverage2.setSize(Size);

		beverage2 = new Liveliness(beverage2);
		beverage2 = new Size(beverage2);

		return beverage2.cost();
	}
}