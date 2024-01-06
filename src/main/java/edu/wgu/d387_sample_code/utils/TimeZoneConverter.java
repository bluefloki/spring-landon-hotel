package edu.wgu.d387_sample_code.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {
    public String getFormattedTime(LocalDateTime localDateTime, String timeZoneId) {
        ZoneId zoneId = ZoneId.of(timeZoneId);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return zonedDateTime.format(formatter);
    }
}