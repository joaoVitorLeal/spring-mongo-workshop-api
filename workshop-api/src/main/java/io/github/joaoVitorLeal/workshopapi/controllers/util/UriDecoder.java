package io.github.joaoVitorLeal.workshopapi.controllers.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UriDecoder {

    public static String decode(String param) {
        try {
            return URLDecoder.decode(param, StandardCharsets.UTF_8);
        }
        catch (UnsupportedCharsetException e) {
            return e.getMessage();
        }
    }

    public static Date convertDate(String textDate, Date defaultDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
