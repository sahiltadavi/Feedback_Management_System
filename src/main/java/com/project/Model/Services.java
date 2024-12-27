package com.project.Model;

import lombok.Data;

@Data
public class Services {
	private int service_id;
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getService_feedback() {
		return service_feedback;
	}
	public void setService_feedback(String service_feedback) {
		this.service_feedback = service_feedback;
	}
	public int getService_rating() {
		return service_rating;
	}
	public void setService_rating(int service_rating) {
		this.service_rating = service_rating;
	}
	private String service_name;
	private String service_feedback;
	private int service_rating;

}
