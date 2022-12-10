package com.example.urlmgrservice.entity;

import com.sun.istack.NotNull;

public class RedirectCreator {
    @NotNull
    private String alias;
    @NotNull
    private String url;

    public RedirectCreator(final String alias, final String url) {
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
        return "RedirectCreationRequest{" + "alias='" + alias + '\'' + ", url='" + url + '\'' + '}';
    }
}
