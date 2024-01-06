package edu.wgu.d387_sample_code.controllers;

import edu.wgu.d387_sample_code.utils.TimeZoneConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class DateController {
    @GetMapping("/timezones")
    @ResponseBody
    public String[] getTimezones() {
        TimeZoneConverter converter = new TimeZoneConverter();

        LocalDateTime localDateTime = LocalDateTime.now();

        String etFormattedTime = converter.getFormattedTime(localDateTime, "America/New_York");
        String mtFormattedTime = converter.getFormattedTime(localDateTime, "America/Denver");
        String utcFormattedTime = converter.getFormattedTime(localDateTime, "UTC");


        return new String[] {etFormattedTime + " ET", mtFormattedTime + " MT", utcFormattedTime + " UTC"};
    }
}
