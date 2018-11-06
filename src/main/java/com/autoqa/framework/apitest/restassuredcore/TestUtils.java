package com.autoqa.framework.apitest.restassuredcore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtils {
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static String getResponseString(Response response){
		log.info("Inside Response to String Converter");
		String strReponse = response.asString();
		log.debug(strReponse);
		return strReponse;
	}
	
	public static String extractJSONResponseValue(Response response, String jsonKey){
		log.info("Inside JSON Response value extracter");
		JsonPath jResponsePath = new JsonPath(response.asString());
		String value = jResponsePath.getString(jsonKey);
		log.debug(value);
		
		return value;
	}
	
	public static String extractXMLResponseValue(Response response, String xmlKey){
		log.info("Inside XML Response value extracter");
		XmlPath xmlResponsePath = new XmlPath(response.asString());
		String value = xmlResponsePath.get(xmlKey).toString();
		log.debug(value);
		
		return value;
	}
	
	public static int getStatusCode(Response response){
		log.info("Inside getStatusCode method");
		int statusCode = response.getStatusCode();
		log.debug(statusCode);
		
		return statusCode;
	}
	
	public static String getStatusMessage(Response response){
		log.info("Inside getStatusLine method");
		String statusLine = response.getStatusLine();
		log.debug(statusLine);
		
		return statusLine;
	}

}
