package com.example.urlmgrservice.utils;

import com.example.urlmgrservice.exception.IllegalUrlException;

import static org.springframework.util.ResourceUtils.isUrl;

public class UrlFormatter {
    public static String format(String rawurl) {
        String url = rawurl.toLowerCase();
        if (url.startsWith("www")) {
            url = "https://" + url;
        }
        if (!isUrl(url)) {
            throw new IllegalUrlException("invalid URL: %s".formatted(rawurl));
        }
        return url;
    }
}
