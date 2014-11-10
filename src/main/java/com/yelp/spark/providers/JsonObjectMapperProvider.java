package com.yelp.spark.providers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Provider;

import java.io.Serializable;


/**
 * Util Class for getting the Json Object Mapper
 */
public class JsonObjectMapperProvider implements Provider<ObjectMapper>, Serializable {

    /**
     * Gets the Json Object Mapper
     * @return
     */
    @Override
    public ObjectMapper get() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }
}
