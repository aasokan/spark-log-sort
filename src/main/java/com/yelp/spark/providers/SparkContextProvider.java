package com.yelp.spark.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.yelp.spark.configuration.JobConfiguration;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Provider for Spark context
 */
public class SparkContextProvider implements Provider<JavaSparkContext> {

    @Inject
    private JobConfiguration jobConfiguration;

    @Override
    public JavaSparkContext get() {
        SparkConf sparkConf = new SparkConf()
                .setMaster(jobConfiguration.getMaster())
                .setAppName(jobConfiguration.getAppName());
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
        return sparkContext;
    }
}
