package com.iquestgroup.dashy.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Monitor {

    private String name;
    private String version;
    private String description;
    private String nodeId;
    private String clusterId;

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("version")
    public String getVersion() {
        return version;
    }

    @JsonSetter("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonSetter("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonGetter("node-id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonSetter("node-id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonGetter("cluster-id")
    public String getClusterId() {
        return clusterId;
    }

    @JsonSetter("cluster-id")
    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("name", name)
                .append("version", version)
                .append("description", description)
                .append("nodeId", nodeId)
                .append("clusterId", clusterId)
                .toString();
    }

}
