package io.github.joaoVitorLeal.workshopapi.controllers.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;

public class UriDecoder {

    public static String decode(String param) {
        try {
            return URLDecoder.decode(param, StandardCharsets.UTF_8);
        }
        catch (UnsupportedCharsetException e) {
            return e.getMessage();
        }
    }
}
