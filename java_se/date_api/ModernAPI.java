package date_api;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;

/**
 * The modern Date/Time API (java.time.*) are immutable, static-factory classes
 * (ie. thread-safe), and much simpler and fast.
 */
@SuppressWarnings("unused")
public class ModernAPI {
	
	public static void timestamps() {
		
		LocalDate date = LocalDate.of(2022, 06, 01); // Represents 2022, June 01.
		LocalTime time = LocalTime.of(13, 45, 1); // Represents 13:45:01.
		
		// Each class has innumerable useful methods. Ex:
		date.getDayOfMonth();
		time.minusMinutes(15);
		
		LocalDate today = LocalDate.now(); // Obtains current date from the system clock.
		LocalTime current = LocalTime.now(); // Obtains current time from the system clock.
		
		LocalDateTime dateTime = LocalDateTime.of(date, time); // Represents 2022, June 01 @ 13:45:01.
		
		ZonedDateTime zoned = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Kolkata")); // Accounts for Time Zone.
		ZonedDateTime converted = zoned.withZoneSameInstant(ZoneId.of("GMT")); // Converts zoned to a different ZoneID.
		 
		Instant ins = Instant.EPOCH; // Represents a single point on the timeline. Used to store timestamps.
		Instant ts = Instant.now();
		
		// .toString() follows ISO 8601 format: 
		// [YYYY-MM-DD]T[00:00:00][+/-0:00TZ]
	}
	
	public static void timePeriods(Temporal d1, Temporal d2) {
		
		if(d1 instanceof LocalDate && d2 instanceof LocalDate) {
			Period diff = Period.between((LocalDate)d1, (LocalDate)d2); 
			// Represents a period of time, wrt. to dates.
		} 
		else if (d1 instanceof LocalTime && d2 instanceof LocalTime) {
			Duration time = Duration.between((LocalTime)d1, (LocalTime)d2); 
			// Represents a period of time, wrt. to time.
		}
		else {
			System.out.println("Only LocalDates or LocalTimes");
		}
		
		
	}

}
