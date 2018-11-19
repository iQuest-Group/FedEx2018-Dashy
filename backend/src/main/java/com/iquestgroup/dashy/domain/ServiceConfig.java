package com.iquestgroup.dashy.domain;

public class ServiceConfig {

    private String url;
    private ServiceType type;

    public ServiceConfig(String url, ServiceType type) {
        this.type = type;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }


}
