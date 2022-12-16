package com.example.urlmgrservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document("tiny-docs")
public class TinyDoc {
    @Id
    private String id;
    private String url;
    private Long timestamp;
    private Long count;

    public TinyDoc() {

    }

    public TinyDoc(String id, String url, Long timestamp, Long count) {
        this.id = id;
        this.url = url;
        this.timestamp = timestamp;
        this.count = count;
    }

    public TinyDoc(String id, String url) {
        this.id = id;
        this.url = url;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.timestamp = timestamp.getTime();
        this.count = 1L;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TinyDoc{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", timestamp=" + timestamp +
                ", count=" + count +
                '}';
    }
}
