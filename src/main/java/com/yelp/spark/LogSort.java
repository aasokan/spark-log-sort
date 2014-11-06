package com.yelp.spark;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yelp.spark.configuration.Options;
import com.yelp.spark.guice.LogSortModule;
import com.yelp.spark.guice.UtilityModule;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Main Class
 */
public class LogSort {
    private static String APP_NAME = "LogSort";

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        // Parse Arguments
        Options options = new Options();
        CmdLineParser cmdLineParser = new CmdLineParser(options);
        try {
            cmdLineParser.parseArgument(args);
        } catch (CmdLineException e) {
            // handling of wrong arguments
            System.err.println(e.getMessage());
            cmdLineParser.printUsage(System.err);
        }

        Injector injector = Guice.createInjector(new UtilityModule(),
                new LogSortModule(options));

        // Run the Job
        LogSortSparkJob logSortSparkJob = injector.getInstance(LogSortSparkJob.class);
        logSortSparkJob.run();
    }
}
