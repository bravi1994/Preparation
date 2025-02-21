package com.first;

import java.util.HashMap;
import java.util.Map;

import com.models.AllOrders;
import com.models.PayloadModel;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SimpleTests {
	
	public static void main(String args[]) {
		System.out.println("Hello");
		RestAssured.baseURI="";
		RequestSpecification req  =new RequestSpecBuilder().setBaseUri("https://swapi-graphql.netlify.app")
		        .setContentType(ContentType.JSON)
		        .build();
		PayloadModel payload = new PayloadModel();
		payload.setQuery("query ExampleQuery {\n \n  allPeople {\n    people {\n      id\n      name\n    }\n  }\n}\n");
		Map<String, String> emptyMap =new HashMap<>();
		payload.setVariables(emptyMap);
		payload.setOperationName("ExampleQuery");

		
	}

}
