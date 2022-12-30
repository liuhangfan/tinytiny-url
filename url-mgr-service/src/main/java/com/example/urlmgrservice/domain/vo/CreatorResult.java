package com.example.urlmgrservice.domain.vo;

public class CreatorResult {
    private String tinyUrl;
    private String alias;
    private String domain;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public CreatorResult(String tinyUrl, String alias, String domain) {
        this.tinyUrl = tinyUrl;
        this.alias = alias;
        this.domain = domain;
    }

    public CreatorResult(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public CreatorResult() {

    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    @Override
    public String toString() {
        return "CreatorResult{" +
                "tinyUrl='" + tinyUrl + '\'' +
                ", alias='" + alias + '\'' +
                ", domain='" + domain + '\'' +
                '}';
    }
}
