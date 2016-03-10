package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.CloudsBean;
import com.bean.MetricsBean;
import com.bean.TimingsBean;
import com.bean.WeatherBean;
import com.bean.WindBean;
import com.dao.jpa.JpaCloudsDaoImpl;
import com.domain.CloudsDTO;


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
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JpaCloudsDaoImpl dao = ctx.getBean("jpaCloudsDaoImpl", JpaCloudsDaoImpl.class);
		System.out.println(dao.getCloudsCount());
		//Call the service and get the response object
		Response response = ClientBuilder.newClient()
				.target(REST_URL)
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		WeatherBean wBean = new WeatherBean();
		//process the response object
		StatusType status = response.getStatusInfo();
		int statusCode = status.getStatusCode();
		if (statusCode == OK_STATUS) {
			String s = response.readEntity(String.class);
			System.out.println("s = " + s);
			wBean = process(s);
		} else {
			System.out.printf("Service returned status: \"%d %s\"\n",
					statusCode, status.getReasonPhrase());
		}
		 CloudsDTO cloudsDTO = new CloudsDTO();
		 cloudsDTO.setAl(wBean.getCloudsBean().getAl());
		 dao.create(cloudsDTO);
		
	}
	
	public static WeatherBean process(String s){
		WeatherBean weatherBean = new WeatherBean();
		mapWeatherBean(s, weatherBean);
		MetricsBean metricsBean = new MetricsBean();
	    weatherBean.setMetricsBean(mapMetricsBean(s, metricsBean));
	    WindBean windBean = new WindBean();
	    weatherBean.setWindBean(mapWindBean(s, windBean));
	    CloudsBean cloudsdBean = new CloudsBean();
	    weatherBean.setCloudsBean(mapCloudsBean(s, cloudsdBean));	    
	    TimingsBean timingsBean = new TimingsBean();
	    weatherBean.setTimingsBean(mapTimingsBean(s, timingsBean));
	    
	    
	    
	    System.out.println(weatherBean.getMetricsBean().getTemp());

		 System.out.println(weatherBean.getId());
		 System.out.println(weatherBean.getMain());
		 System.out.println(weatherBean.getDescription());
		 
		 System.out.println(weatherBean.getCity());
		return weatherBean;
		 
			 
		 
		 
	}
	
	public static WeatherBean mapWeatherBean(String s, WeatherBean weatherBean){
		JSONObject obj = new JSONObject(s);
		weatherBean.setCity(obj.getString("name"));
		JSONObject res = obj.getJSONArray("weather").getJSONObject(0);
	    weatherBean.setId(res.getInt("id"));
	    weatherBean.setMain(res.getString("main"));
	    weatherBean.setDescription(res.getString("description"));
	    weatherBean.setIcon(res.getString("icon"));
		return weatherBean;
	}
	
	public static MetricsBean mapMetricsBean(String s, MetricsBean metricsBean){
		JSONObject obj = new JSONObject(s);
		JSONObject res = obj.getJSONObject("main");
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
		windBean.setSpeed(res.getInt("speed"));
		windBean.setDeg(res.getInt("deg"));
		return windBean;
	}
	
	public static CloudsBean mapCloudsBean(String s, CloudsBean cloudsBean){
		JSONObject obj = new JSONObject(s);
		JSONObject res = obj.getJSONObject("clouds");
		cloudsBean.setAl(res.getInt("all"));
		return cloudsBean;
	}
		
	public static TimingsBean mapTimingsBean(String s, TimingsBean timingsBean){
		JSONObject obj = new JSONObject(s);
		JSONObject res = obj.getJSONObject("sys");
		timingsBean.setSunrise(res.getInt("sunrise"));
		timingsBean.setSunset(res.getInt("sunset"));
		return timingsBean;
	}
	
}
