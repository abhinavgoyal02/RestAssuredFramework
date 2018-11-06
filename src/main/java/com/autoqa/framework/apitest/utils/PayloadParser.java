package com.autoqa.framework.apitest.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PayloadParser {
	private static Logger payloadParseLogger = LogManager.getLogger(PayloadParser.class.getName());

	public static String generatePayloadString(String fileName) throws IOException {
		payloadParseLogger.info("Inside generatePayloadString method");
		
		String basePath = System.getProperty("user.dir") + "\\resources\\payloads\\";
		try {
			return new String(Files.readAllBytes(Paths.get(basePath + fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			payloadParseLogger.error(e.getMessage());
			return null;
		}
	}

}
