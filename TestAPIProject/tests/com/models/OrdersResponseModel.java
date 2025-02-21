package com.models;

import java.util.List;

public class OrdersResponseModel {
	
	public List<Workorder> workorder;

	public List<Workorder> getWorkorder() {
		return workorder;
	}

	public void setWorkorder(List<Workorder> workorder) {
		this.workorder = workorder;
	}
	

}
