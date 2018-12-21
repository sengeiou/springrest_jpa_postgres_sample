
package com.trustaml.dataservice.listener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utilities {

	private static final String COLON = ":";
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String DATE_MATCH_FORMAT = "\\d{4}-\\d{2}-\\d{2}";
	private static final String NAMES = "Andrea:Juan:Isaac:Sandra:Michael:Annabel";

	/**
	 * If the input parameter is integer, then converts the String input to
	 * Integer output else return null
	 *
	 * @param input
	 * @return
	 */
	// public static Integer isInteger(String input) {
	// Integer output = 0;
	// if (StringUtils.isNumeric(input)) {
	// output = Integer.parseInt(input);
	// }
	// return output;
	// }

	/**
	 * Convert date from String to Date object
	 *
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date matchDate(String date) {
		try {
			if (hasFormat(date)) {
				DateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
				return formatter.parse(date);
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return null;
	}

	/**
	 * Check if the string has a Date format
	 *
	 * @param date
	 * @return
	 */
	private static boolean hasFormat(String date) {
		return date.matches(DATE_MATCH_FORMAT);
	}

	/**
	 * Gets random user names
	 *
	 * @return
	 */
	public static String getRandomUsers() {
		String[] wordsAsArray = NAMES.split(COLON);
		int index = new Random().nextInt(wordsAsArray.length);

		return wordsAsArray[index];
	}

}
