package com.example.urlmgrservice.domain.vo;

public class CreatorResult {
    private String tinyUrl;

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
                '}';
    }
}
