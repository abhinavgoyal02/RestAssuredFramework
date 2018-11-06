package com.autoqa.framework.apitest.restassuredcore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls {
	/* Different types of REST calls 
	 * are made from this class
	 */
	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
	
	public static Response GETRequest(String URI){
		RequestSpecification requestSpecs = RestAssured.given().contentType(ContentType.JSON);
		Response response = requestSpecs.get(URI); 
		
		log.info("Inside GETRequest call");
		log.debug(requestSpecs.log().all());
		
		return response;
	}
	
	public static Response POSTRequest(String URI, String JSONPayload){
		RequestSpecification requestSpecs = RestAssured.given().contentType(ContentType.JSON).body(JSONPayload);
		Response response = requestSpecs.post(URI); 
		
		log.info("Inside POSTRequest call");
		log.debug(requestSpecs.log().all());
		
		return response;
	}
	
	public static Response POSTRequest(String URI, String JSONPayload, String sessionCookie){
		RequestSpecification requestSpecs = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(JSONPayload)
				.header("cookie", sessionCookie);
		Response response = requestSpecs.post(URI); 
		
		log.info("Inside POSTRequest call with Session Cookie");
		log.debug(requestSpecs.log().all());
		
		return response;
	}
	
	public static Response PUTRequest(String URI, String JSONPayload){
		RequestSpecification requestSpecs = RestAssured.given().contentType(ContentType.JSON).body(JSONPayload);
		Response response = requestSpecs.put(URI); 
		
		log.info("Inside PUTRequest call");
		log.debug(requestSpecs.log().all());
		
		return response;
	}
	
	public static Response DELETERequest(String URI, String JSONPayload){
		RequestSpecification requestSpecs = RestAssured.given().contentType(ContentType.JSON).body(JSONPayload);
		Response response = requestSpecs.delete(URI); 
		
		log.info("Inside DELETERequest call");
		log.debug(requestSpecs.log().all());
		
		return response;
	}
}
