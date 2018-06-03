package com.mycompany.messaging.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void testGetDefaultDateFormatFormatter() throws ParseException {
		String date = "2018-06-03T12:35:36.005";
		SimpleDateFormat sdf = DateUtils.getDefaultDateFormatFormatter();
		Date dateObject = sdf.parse(date);
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(dateObject);
		Assert.assertEquals(2018, cal.get(Calendar.YEAR));
	}

	@Test
	public void testParseDate() throws ParseException {
		String date = "2018-06-03T12:35:36.005";
		Date dateObject = DateUtils.parseDate(date, null);
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(dateObject);
		Assert.assertEquals(2018, cal.get(Calendar.YEAR));
	}

	@Test
	public void testParseDateWhenFormatNonNull() throws ParseException {
		String date = "2018-06-03";
		Date dateObject = DateUtils.parseDate(date, "yyyy-MM-dd");
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(dateObject);
		Assert.assertEquals(2018, cal.get(Calendar.YEAR));
	}

}
