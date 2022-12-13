package com.example.urlmgrservice.domain.dto;

import com.sun.istack.NotNull;

public class RedirectCreator {
    @NotNull
    private String alias;
    @NotNull
    private String url;

    public RedirectCreator(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RedirectCreator{" +
                "alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
