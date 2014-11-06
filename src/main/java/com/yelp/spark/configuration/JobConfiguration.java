package com.yelp.spark.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Job configuration File
 */
public class JobConfiguration {

    @JsonProperty
    @NotNull
    public String inputDataPath;

    @JsonProperty
    public boolean isZipped = false;

    @JsonProperty
    public String appName = "LogSort";

    @JsonProperty
    public String master = "local";

    public String getInputDataPath() {
        return inputDataPath;
    }

    public void setInputDataPath(String inputDataPath) {
        this.inputDataPath = inputDataPath;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public boolean isZipped() {
        return isZipped;
    }

    public void setZipped(boolean isZipped) {
        this.isZipped = isZipped;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
