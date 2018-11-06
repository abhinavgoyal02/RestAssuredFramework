package com.autoqa.framework.apitest.restassuredcore;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autoqa.framework.apitest.restassuredcore.RESTCalls;
import com.autoqa.framework.apitest.restassuredcore.TestUtils;
import com.autoqa.framework.apitest.restassuredcore.URL;
import com.autoqa.framework.apitest.utils.PayloadParser;

import io.restassured.response.Response;

public class JiraLoginTest {
	private static Logger log = LogManager.getLogger(JiraLoginTest.class.getName());

	@Test
	public void doLogin() throws IOException {
		log.info("Starting Test Case : doLogin()");

		String loginPayload = PayloadParser.generatePayloadString("JIRALogin.json");
		String endPointURI = URL.getEndPoint("rest/auth/1/session");
		Response loginResponse = RESTCalls.POSTRequest(endPointURI, loginPayload);
		String response = TestUtils.getResponseString(loginResponse);

		System.out.println("#### >> " + response);
		log.info(loginResponse.asString());

		String sessionID = TestUtils.extractJSONResponseValue(loginResponse, "session.value");
		System.out.println("#### >> " + sessionID);

		int statusCode = TestUtils.getStatusCode(loginResponse);
		Assert.assertEquals(statusCode, 200);

		log.info("JIRA JSessionID = " + sessionID);

	}
}
