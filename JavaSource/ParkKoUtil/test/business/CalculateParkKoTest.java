package business;

import java.sql.Timestamp;

import org.junit.Test;

import business.CalculateParkKo;
import business.DateTimeHelper;
import static org.junit.Assert.*;

public class CalculateParkKoTest {
	CalculateParkKo calculate = new CalculateParkKo();

	@Test
	public void testCalculateParkHours_Bangkok() {
		String timeBangkokStart = "24/12/2014 01:50 PM";
		String timeBangkokEnd = "26/12/2014 04:02 PM";

		Timestamp startTime = DateTimeHelper.getTimestamp(timeBangkokStart);
		Timestamp endTime = DateTimeHelper.getTimestamp(timeBangkokEnd);

		int expectedHour = 51;
		int actualHour = calculate.calculateRoundUpParkHour(startTime, endTime);
		assertEquals(expectedHour, actualHour);
	}

	@Test
	public void testCalculateParkHours_Lampang() {
		String timeLampangStart = "25/12/2014 09:00 PM";
		String timeLampangEnd = "26/12/2014 06:30 AM";

		Timestamp startTime = DateTimeHelper.getTimestamp(timeLampangStart);
		Timestamp endTime = DateTimeHelper.getTimestamp(timeLampangEnd);

		int expectedHour = 10;
		int actualHour = calculate.calculateRoundUpParkHour(startTime, endTime);
		assertEquals(expectedHour, actualHour);
	}

	@Test
	public void testCalculateSpecialHour_Bangkok() {
		String timeBangkokStart = "24/12/2014 01:50 PM";
		String timeBangkokEnd = "26/12/2014 04:02 PM";

		Timestamp startTime = DateTimeHelper.getTimestamp(timeBangkokStart);
		Timestamp endTime = DateTimeHelper.getTimestamp(timeBangkokEnd);

		int expectedHour = 6;
		int actualHour = calculate.calculateSpecialHour(startTime, endTime);
		assertEquals(expectedHour, actualHour);
	}

	@Test
	public void testCalculateSpecialHour_Lampang() {
		String timeLampangkStart = "25/12/2014 09:00 PM";
		String timeLampangEnd = "26/12/2014 06:30 AM";

		Timestamp startTime = DateTimeHelper.getTimestamp(timeLampangkStart);
		Timestamp endTime = DateTimeHelper.getTimestamp(timeLampangEnd);

		int expectedHour = 3;
		int actualHour = calculate.calculateSpecialHour(startTime, endTime);
		assertEquals(expectedHour, actualHour);
	}

	@Test
	public void testCalculateHour_Bangkok_start_11_00_end_16_02_should_be_6_hours() {
		String timeBangkokStart = "26/12/2014 11:00 AM";
		String timeBangkokEnd = "26/12/2014 04:02 PM";

		Timestamp startTime = DateTimeHelper.getTimestamp(timeBangkokStart);
		Timestamp endTime = DateTimeHelper.getTimestamp(timeBangkokEnd);

		int expectedHour = 0;
		int actualHour = calculate.calculateSpecialHour(startTime, endTime);
		assertEquals(expectedHour, actualHour);
	}

}
