package org.example;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class Time {
    private final String DEFAULT_TIME_ZONE = "UTC";
    public String getTime(String zone){
        ZoneId zoneId;
        if(!isTimeZoneValid(zone)){
            zone = DEFAULT_TIME_ZONE;
        }
        zone = zone.replace(" ","+");
        zoneId = ZoneId.of(zone);
        Instant now = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now,
                zoneId);
        return zdt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " " + zone;
    }

    public static boolean isTimeZoneValid(String timeZone) {
        if ("".equals(timeZone) || timeZone == null) {
            return false;
        }

        timeZone = timeZone.replace(" ", "+");
        try {
            ZoneId.of(timeZone);
        } catch (RuntimeException e) {
            return false;
        }
        return true;
    }
}
