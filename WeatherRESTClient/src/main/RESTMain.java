package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.domain.MetricsBean;
import com.domain.WeatherBean;
import com.domain.WindBean;

/**
 * @author Richard
 * SHIFT ALT J
 * Call the RESTful web service at REST_URL defined below
 */

public class RESTMain {
	 /**
	  * Call the web service and display the response
     * @param args
     */
	
	public static final String REST_URL ="http://api.openweathermap.org/data/2.5/weather?zip=06479,us&appid=bad710b18f780d46584d39f15932cbd3";
	//public static final String REST_URL ="http://rate-exchange.appspot.com/currency?from=USD&to=EUR";
	public static final int OK_STATUS = Response.Status.OK.getStatusCode();
	
	public static void main(String[] args) {
		//Call the service and get the response object
		Response response = ClientBuilder.newClient()
				.target(REST_URL)
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		
		// process the response object
		StatusType status = response.getStatusInfo();
		int statusCode = status.getStatusCode();
		if (statusCode == OK_STATUS) {
			String s = response.readEntity(String.class);
			System.out.println("s = " + s);
			process(s);
		} else {
			System.out.printf("Service returned status: \"%d %s\"\n",
					statusCode, status.getReasonPhrase());
		}
		
	}
	
	public static void process(String s){
		WeatherBean weatherBean = new WeatherBean();
		mapWeatherBean(s, weatherBean);
		//JSONObject obj = new JSONObject(s);
		//String n = obj.getString("name");
		//int a = obj.getInt("age");
		//System.out.println(n + " "); 
		//JSONObject res = obj.getJSONArray("weather").getJSONObject(0);
	   //System.out.println(res.getInt("id"));
		 System.out.println(weatherBean.getId());
		 System.out.println(weatherBean.getMain());
		 System.out.println(weatherBean.getDescription());
		 
		 System.out.println(weatherBean.getCity());
	}
	
	public static void mapWeatherBean(String s, WeatherBean weatherBean){
		JSONObject obj = new JSONObject(s);
		weatherBean.setCity(obj.getString("name"));
		JSONObject res = obj.getJSONArray("weather").getJSONObject(0);
	    weatherBean.setId(res.getInt("id"));
	    weatherBean.setMain(res.getString("main"));
	    weatherBean.setDescription(res.getString("description"));
	    weatherBean.setIcon(res.getString("icon"));
	    MetricsBean metricsBean = new MetricsBean();
	    weatherBean.setMetricsBean(mapMetricsBean(s, metricsBean));
	    WindBean windBean 
	    System.out.println(metricsBean.getTemp());
	}
	
	public static MetricsBean mapMetricsBean(String s, MetricsBean metricsBean){
		JSONObject obj = new JSONObject(s);
		JSONObject res = obj.getJSONObject("main");
		System.out.println("temp = [" +res.getInt("temp") + "]");
		metricsBean.setTemp(res.getInt("temp"));
		metricsBean.setPressure(res.getInt("pressure"));
		metricsBean.setHumidity(res.getInt("humidity"));
		metricsBean.setTempMin(res.getInt("temp_min"));
		metricsBean.setTempMax(res.getInt("temp_max"));
		return metricsBean;
		
	}
	
	public static WindBean mapWindBean(String s, WindBean windBean){
		JSONObject obj = new JSONObject(s);
		JSONObject res = obj.getJSONObject("wind");
		System.out.println("speed = [" +res.getInt("speed") + "]");
		windBean.setSpeed(res.getInt("speed"));
		windBean.setDeg(res.getInt("deg"));
		return windBean;
	}
	
	

}
