package com.yelp.spark;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.Map;

/**
 * Log Record Object
 */
public class LogRecord {

    @JsonProperty("unique_visitor_id")
    public String uniqueVisitorId = null;

    @JsonProperty("device_id")
    public String deviceId = null;

    @JsonProperty("log_begin_time")
    public String beginTime = null;

    protected Map<String,Object> other = new HashMap<>();

    @JsonAnyGetter
    public Map<String,Object> any() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, Object value) {
        other.put(name, value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("unique_visitor_id", uniqueVisitorId)
                .add("device_id", deviceId)
                .add("log_begin_time", beginTime)
                .toString();
    }
}
