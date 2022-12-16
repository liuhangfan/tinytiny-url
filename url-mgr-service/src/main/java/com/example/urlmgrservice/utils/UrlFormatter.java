package com.example.urlmgrservice.utils;

import static org.springframework.util.ResourceUtils.isUrl;

public class UrlFormatter {
    public static String format(String url) {
        url = url.toLowerCase();
        if (url.startsWith("www")) {
            url = "https://" + url;
        }
        if (!isUrl(url)) {
            throw new IllegalArgumentException("invalid URL");
        }
        return url;
    }
}
