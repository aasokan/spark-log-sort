package com.yelp.spark.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Provider;


/**
 * Util Class for getting the Json Object Mapper
 */
public class JsonObjectMapperProvider implements Provider<ObjectMapper> {

    /**
     * Gets the Json Object Mapper
     * @return
     */
    @Override
    public ObjectMapper get() {
        final ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }
}
