package com.autoqa.framework.apitest.restassuredcore;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autoqa.framework.apitest.utils.PayloadParser;

import io.restassured.response.Response;

public class CreateJiraIssueTest {
	private static Logger log = LogManager.getLogger(CreateJiraIssueTest.class.getName());
	private static String SESSION_COOKIE= null;

	@BeforeMethod
	public void setUp() throws IOException {

		SESSION_COOKIE = "JSESSIONID=" + BaseTest.getLoginSessionID();

	}

	@Test
	public void createIssue() throws IOException {
		log.info("Starting CreateIssue Test :");

		String createIssuePayload = PayloadParser.generatePayloadString("CreateJiraIssue.json");
		String endPointURI = URL.getEndPoint("rest/api/2/issue");
		Response createIssueReponse = RESTCalls.POSTRequest(endPointURI, createIssuePayload, SESSION_COOKIE);
		log.info(createIssueReponse.asString());
		
		int statusCode = TestUtils.getStatusCode(createIssueReponse);
		log.info("Status Code = " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String key = TestUtils.extractJSONResponseValue(createIssueReponse, "key");
		log.info("New Issue Key = " + key);
	}
}
