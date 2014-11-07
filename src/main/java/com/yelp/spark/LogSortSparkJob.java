package com.yelp.spark;

import com.google.inject.Inject;
import com.yelp.spark.configuration.JobConfiguration;
import com.yelp.spark.functions.SortMapFunction;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Execute the Spark Job
 */
public class LogSortSparkJob {

    @Inject
    private JavaSparkContext sparkContext;

    @Inject
    private JobConfiguration configuration;

    @Inject
    private SortMapFunction sortMapFunction;

    public void run(){
        JavaRDD<String> inputRDDs = sparkContext.textFile(configuration.getInputDataPath());
        JavaPairRDD<String,String> inputPairRDDs = inputRDDs.mapToPair(sortMapFunction);

        System.out.println(StringUtils.join("Number of lines in ",configuration.getInputDataPath()," are ", inputRDDs.count()));
        System.out.println(StringUtils.join("Distinct Records ",inputPairRDDs.countByKey().keySet().size()));
    }
}
