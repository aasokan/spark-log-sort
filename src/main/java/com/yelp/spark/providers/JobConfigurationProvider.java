package com.yelp.spark.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yelp.spark.configuration.JobConfiguration;
import com.yelp.spark.configuration.Options;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Provider for Job Configuration
 */
public class JobConfigurationProvider implements Provider<JobConfiguration> {

    @Inject
    private Logger log;

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private Options options;


    @Override
    public JobConfiguration get() {
        JobConfiguration jobConfiguration = null;
        try {
            final File configFile = new File(options.configFile);
            jobConfiguration = objectMapper.readValue(Files.toByteArray(configFile), JobConfiguration.class);
        } catch (IOException e) {
            log.error("Failed deserializing the Job Configuration", e);
        }
        return jobConfiguration;
    }
}
