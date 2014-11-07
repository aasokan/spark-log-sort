package com.yelp.spark.guice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.yelp.spark.LogSort;
import com.yelp.spark.providers.JsonObjectMapperProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Json Module
 */
public class UtilityModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ObjectMapper.class).toProvider(JsonObjectMapperProvider.class).asEagerSingleton();
        bind(Logger.class).toInstance(LoggerFactory.getLogger(LogSort.class));
    }
}
