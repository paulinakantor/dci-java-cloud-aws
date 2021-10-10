package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Main Lambda class with handleRequest method
 */
public class HandlerS3 implements RequestHandler<S3Event, String> {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        final LambdaLogger logger = context.getLogger();
        final S3EventNotification.S3EventNotificationRecord record = s3Event.getRecords().get(0);
        final String bucket = record.getS3().getBucket().getName();
        final String objectKey = record.getS3().getObject().getUrlDecodedKey();

        logger.log("EVENT: " + gson.toJson(s3Event));
        logger.log("CONTEXT: " + gson.toJson(context));
        logger.log("RECORD: " + record);
        logger.log("SOURCE BUCKET: " + bucket);
        logger.log("SOURCE KEY: " + objectKey);

        return "File from S3 arrived!";
    }
}
