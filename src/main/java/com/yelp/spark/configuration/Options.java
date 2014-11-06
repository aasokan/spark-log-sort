package com.yelp.spark.configuration;

import org.kohsuke.args4j.Option;

/**
 * Input Arguments class
 */
public class Options {

    @Option(name="--configFile", usage="Path to the Config File", required = true)
    public String configFile;
}
