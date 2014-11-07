package com.yelp.spark;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class LogRecordTest {

    public ObjectMapper getObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Test
    public void testDeserialization() throws IOException {
        File file = new File("sample.txt");
        for(String line : Files.readLines(file, Charset.defaultCharset())) {
            ObjectMapper objectMapper = getObjectMapper();
            LogRecord record = objectMapper.readValue(line, LogRecord.class);
            System.out.println(record.toString());
        }
    }

}