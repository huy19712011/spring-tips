package dev.cat.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {

    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime parseToLocalDateTime(String date) {
        return LocalDateTime.parse(date, dateTimeFormatter);

    }
}
