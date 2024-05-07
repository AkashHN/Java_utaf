package com.feuji.utils;

import static io.restassured.RestAssured.given;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * The GenerateToken class provides utility methods to obtain an authentication
 * token.
 */
public class GenerateToken {

	public static String token;

	/**
	 * Retrieves the authentication token using the provided API request body and
	 * endpoint. If the token is already generated, returns the existing token.
	 * 
	 * @param path The path of the JSON file containing the API request body for
	 *             token generation
	 * @return The authentication token
	 */
	public static String getToken(String path) {
		if (token == null) {
			String tokenAPIRequestBody = FileReader.getData(path).toString();
			Response tokenAPIResponse = given().contentType(ContentType.JSON).body(tokenAPIRequestBody)
					.baseUri(Route.BASE_URL).when().post(Route.AUTH_END_POINT).then().assertThat().statusCode(200)
					.extract().response();
			token = JsonPath.read(tokenAPIResponse.body().asString(), "$.token");
		}
		return token;
	}

}
