/**
 *
 */
package com.mycompany.messaging.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author mishradma
 *
 */
public class DateUtils {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	private static final SimpleDateFormat DEFAULT_DATE_FORMAT_FORMATTER = new SimpleDateFormat(
			DateUtils.DEFAULT_DATE_FORMAT);

	/**
	 * @return the defaultDateFormatFormatter
	 */
	public static SimpleDateFormat getDefaultDateFormatFormatter() {
		return DEFAULT_DATE_FORMAT_FORMATTER;
	};

	/**
	 * @return the customDateFormatFormatter
	 */
	public static SimpleDateFormat constructDateFormatFormatter(String pattern) {
		return new SimpleDateFormat(pattern);
	};

	public static Date parseDate(String dateStr, String format) throws ParseException {
		Date parsedDate;
		if (StringUtils.isNotBlank(dateStr)) {
			if (StringUtils.isNotBlank(format)) {
				parsedDate = new SimpleDateFormat(format).parse(dateStr);
			} else {
				parsedDate = getDefaultDateFormatFormatter().parse(dateStr);
			}
		} else {
			parsedDate = null;
		}
		return parsedDate;
	}

}
