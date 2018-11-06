package com.autoqa.framework.apitest.restassuredcore;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.autoqa.framework.apitest.utils.PayloadParser;

import io.restassured.response.Response;

public class BaseTest {
	
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	public static String getLoginSessionID() throws IOException{
		log.info("Inside  getLoginSessionID() method");
		
		String loginPayload = PayloadParser.generatePayloadString("JIRALogin.json");
		String endPointURI = URL.getEndPoint("rest/auth/1/session");
		Response loginResponse = RESTCalls.POSTRequest(endPointURI, loginPayload);
		String sessionID = TestUtils.extractJSONResponseValue(loginResponse, "session.value");
		
		log.info("Current JIRA JSessionID = " + sessionID);
		
		return sessionID;
	}

}
