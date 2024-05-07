package com.feuji.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

/**
 * The FileReader class provides utility methods to read data from files.
 */
public class FileReader {

	/**
	 * Reads JSON data from the specified file path and returns it as a JSONObject.
	 * 
	 * @param filePath The path of the JSON file to read
	 * @return JSONObject containing the data read from the file, or null if an
	 *         error occurs
	 */
	public static JSONObject getData(String filePath) {
		JSONObject jsonObject = null;
		try {
			String data = FileUtils.readFileToString(new File(filePath), "UTF-8");
			jsonObject = new JSONObject(data);
		} catch (IOException e) {
		}
		return jsonObject;
	}
}
