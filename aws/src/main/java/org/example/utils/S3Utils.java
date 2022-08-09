package org.example.utils;

import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.InputStream;
import java.util.logging.Logger;

public class S3Utils {

    public InputStream getFileContentInS3(String bucketName, String key) {
        InputStream objectStream = null;
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.US_EAST_1)
                    .withForceGlobalBucketAccessEnabled(true)
                    .build();
            objectStream = s3Client.getObject(new GetObjectRequest(bucketName, key)).getObjectContent();

        }catch (SdkClientException | NullPointerException e){
            Logger.getLogger(e.getMessage());
            Logger.getLogger("*** ==> There is no file named : " + key);
        }
        return objectStream;
    }
}
