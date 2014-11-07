package com.yelp.spark.functions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.yelp.spark.LogRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.function.PairFunction;
import org.slf4j.Logger;
import scala.Tuple2;

import java.io.IOException;
import java.io.NotSerializableException;

/**
 * Class to get the Map Function
 */
public class SortMapFunction implements PairFunction<String, String, String> {

    @Inject
    private Logger logger;

    @Inject
    private ObjectMapper objectMapper;

    @Override
    public Tuple2<String, String> call(String x) throws Exception {
        try {
            final LogRecord logRecord = objectMapper.readValue(x, LogRecord.class);
            return  new Tuple2(logRecord.toString(), x);
        } catch (NotSerializableException e) {
            logger.error("Not serializable", e);
            logger.error(x);
            // Ignore errors
        } catch (IOException e) {

        }
        return  new Tuple2<>(StringUtils.EMPTY, x);
    }
}
