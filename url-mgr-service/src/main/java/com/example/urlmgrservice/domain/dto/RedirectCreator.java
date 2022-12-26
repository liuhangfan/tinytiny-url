package com.example.urlmgrservice.domain.dto;


import javax.validation.constraints.NotNull;

public class RedirectCreator {
    private String alias;
    @NotNull
    private String url;

    private String domain;

    @Override
    public String toString() {
        return "RedirectCreator{" +
                "alias='" + alias + '\'' +
                ", url='" + url + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public RedirectCreator(String alias, String url, String domain) {
        this.alias = alias;
        this.url = url;
        this.domain = domain;
    }

    public RedirectCreator(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }

    public RedirectCreator() {
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

}
