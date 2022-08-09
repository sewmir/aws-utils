package org.example;

import org.example.utils.S3Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ReadTextFileFromS3 {

    public static void main(String[] args){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new S3Utils().getFileContentInS3("S3_BUCKET_NAME", "fileKey")));
            String stringLine;
            while ((stringLine = reader.readLine()) !=null){
                Logger.getLogger( "String line => " + stringLine);
            }
        }catch (IOException e){
            Logger.getLogger(e.getMessage());
        }
    }
}