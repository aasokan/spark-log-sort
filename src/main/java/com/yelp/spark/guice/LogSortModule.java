package com.yelp.spark.guice;

import com.google.inject.AbstractModule;
import com.yelp.spark.LogSortSparkJob;
import com.yelp.spark.configuration.JobConfiguration;
import com.yelp.spark.configuration.Options;
import com.yelp.spark.functions.SortMapFunction;
import com.yelp.spark.providers.JobConfigurationProvider;
import com.yelp.spark.providers.SparkContextProvider;
import org.apache.spark.api.java.JavaSparkContext;

import javax.validation.constraints.NotNull;

/**
 * Guice Module
 */
public class LogSortModule extends AbstractModule {
    private Options options;

    public LogSortModule(@NotNull Options options) {
        this.options = options;
    }

    @Override
    protected void configure() {
        bind(Options.class).toInstance(options);
        bind(JobConfiguration.class).toProvider(JobConfigurationProvider.class).asEagerSingleton();
        bind(JavaSparkContext.class).toProvider(SparkContextProvider.class).asEagerSingleton();
        bind(SortMapFunction.class).asEagerSingleton();

        bind(LogSortSparkJob.class).asEagerSingleton();
    }
}
