package com.domain;

public class WeatherBean {

	private int id;
    private String main;
    private String description;
    private String icon;
    private String city;
    private int zipCode;
    private MetricsBean metricsBean;
    private WindBean windBean;
    private CloudsBean cloudsBean;
    private TimingsBean timingsBean;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public MetricsBean getMetricsBean() {
		return metricsBean;
	}
	public void setMetricsBean(MetricsBean metricsBean) {
		this.metricsBean = metricsBean;
	}
	public WindBean getWindBean() {
		return windBean;
	}
	public void setWindBean(WindBean windBean) {
		this.windBean = windBean;
	}
	public CloudsBean getCloudsBean() {
		return cloudsBean;
	}
	public void setCloudsBean(CloudsBean cloudsBean) {
		this.cloudsBean = cloudsBean;
	}
	public TimingsBean getTimingsBean() {
		return timingsBean;
	}
	public void setTimingsBean(TimingsBean timingsBean) {
		this.timingsBean = timingsBean;
	}
    
 }
