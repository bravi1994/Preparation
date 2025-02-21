package com.first;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.models.PayloadModel;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DemoGraphQL {

	public static void main(String[] args) {
		
		String query =" {\r\n"
				+ "  getDicts {\r\n"
				+ "    titleTypes\r\n"
				+ "    trackTypes\r\n"
				+ "    providers\r\n"
				+ "    priorities\r\n"
				+ "    statusStages\r\n"
				+ "    statuses\r\n"
				+ "    qcReportStatus\r\n"
				+ "    qcIssueStatus\r\n"
				+ "  }\r\n"
				+ "}\r\n"
				;
		System.out.println("Hello");
		RestAssured.baseURI="https://k6wl56uhvzgxvonbbbvom3o4z4.appsync-api.us-east-1.amazonaws.com/graphql";
		RequestSpecification req  = RestAssured.given();
		PayloadModel payload = new PayloadModel();
		payload.setQuery("query GetDictsQuery {\r\n"
				+ "  getDicts {\r\n"
				+ "    titleTypes\r\n"
				+ "    trackTypes\r\n"
				+ "    providers\r\n"
				+ "    priorities\r\n"
				+ "    statusStages\r\n"
				+ "    statuses\r\n"
				+ "    qcReportStatus\r\n"
				+ "    qcIssueStatus\r\n"
				+ "  }\r\n"
				+ "}");
		Map<String, String> emptyMap =new HashMap<>();
		payload.setVariables(emptyMap);
		payload.setOperationName("ExampleQuery");
		JSONObject  json = new JSONObject();
		json.put("query", query);
		req.header("x-api-key", "da2-wabz5cc6jfa7fb2ksi5zxynk6y");
		
		req.body(json.toString());
		
		Response response = req.post();
		   
	    /*
	    	Printing Response as string
	    */
	    System.out.println(response.asString());
	   
	    /*
	    	Get Validatable response to perform validation
	    */
	    ValidatableResponse validatableResponse = response.then();
	   
	    /*
	    	Validate status code as 201
	    */
	    validatableResponse.statusCode(200);

	    System.out.println(response.getStatusCode());
	    System.out.println(response.getTime());
		

	}

}
