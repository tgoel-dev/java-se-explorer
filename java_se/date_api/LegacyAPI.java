package date_api;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Date and Time API is typically used for storing review/message times, date
 * posted, etc.
 */
public class LegacyAPI {
	// Legacy Date/Time API is not very well written, but is widely used.

	/*
	 * Time is stored as number relative to the EPOCH time (= 0 = 01/01/1970 UTC
	 * 0:00). A day = 24h * 60m * 60s = 86400.
	 */

	@SuppressWarnings({"deprecation", "unused"})
	public static void jdk1_0() {

		Date absolute = new Date(122, 5, 1); // Represents 2022, June 01 UTC 0:00.
		/*
		 * Date(YYY, MM, DD) - YYY is calculated as 1900 + YYY, Months = [0,11], and
		 * Days = [1,31];
		 */

		Date current = new Date(); // Represents current date/time.

		/*
		 * (-) Does not allow for storing different time zones, no differentiation
		 * between date and time. Absurd year and month rules. Not thread-safe.
		 */
	}

	public static void jdk1_1() {

		Calendar improvedDate = new GregorianCalendar(2022, 5, 1); // Represents 2022, June 01 UTC 0:00.

		improvedDate.after(new GregorianCalendar(2022, 5, 2)); // returns boolean.
		improvedDate.before(new GregorianCalendar(2022, 9, 2));

		improvedDate.add(9, Calendar.MONTH); // Adds 5 months to the date.
		improvedDate.roll(9, Calendar.MONTH); // Adds 5 months, does not affect the year.

		// Used to represent Time Zone for the date.
		TimeZone tz = TimeZone.getTimeZone("Asia/Kolkata");

		improvedDate.setTimeZone(tz);

		/*
		 * (+) Addresses the Year rules, and storing the Time Zone, as well as adds
		 * other useful features.
		 * 
		 * (-) Month rules still not fixed, no differentiation between date and time.
		 * Not thread-safe.
		 */
	}

}
