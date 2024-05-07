package com.feuji.context;

public class Constants {
	
	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/reports/ExtentReport.html";
	
	public final static String BASE_PROPERTY_PATH = WORKING_DIRECTORY + "/src/test/resources/config/base.properties";

	public final static String LETYSHOPS_PROPERTY_PATH = WORKING_DIRECTORY + "/src/test/resources/config/letyshops.properties";
	
	public static final String JSON_SCHEMA = WORKING_DIRECTORY + "/data/expectedJSONSchema.json";

	public static final String TOKEN_REQUEST_BODY = WORKING_DIRECTORY + "/data/tokenRequestBody.json";
	
	public static final String UI_JSON_DATA = WORKING_DIRECTORY + "/data/data.json";
	
	public static final String MOBILE_JSON_DATA = WORKING_DIRECTORY + "/data/letyShops.json";
}
