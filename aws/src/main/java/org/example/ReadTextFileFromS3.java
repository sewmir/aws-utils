package org.example;

import org.example.utils.S3Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTextFileFromS3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(S3Utils.getFileContentInS3("S3_BUCKET_NAME", "fileKey")));
        String stringLine;
        while ((stringLine = reader.readLine()) !=null){
            System.out.println("String line => " + stringLine);
        }
    }
}