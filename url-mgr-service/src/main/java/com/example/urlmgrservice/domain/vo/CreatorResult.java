package com.example.urlmgrservice.domain.vo;

public class CreatorResult {
    private String tinyUrl;
    private String error_msg;

    public CreatorResult(String tinyUrl, String error_msg) {
        this.tinyUrl = tinyUrl;
        this.error_msg = error_msg;
    }

    public CreatorResult() {

    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    @Override
    public String toString() {
        return "creatorResult{" +
                "tinyUrl='" + tinyUrl + '\'' +
                ", error='" + error_msg + '\'' +
                '}';
    }
}
