/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vanilla.transmilenio.servicio;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.File;
import java.io.*;

/**
 *
 * @author andco
 */
public class AmazonServicio {

    final String accessKeyId = "";
    final String secretAccessKey = "";
    final String bucketName = "";
    private AmazonS3 s3client;
    

    public AmazonServicio() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        s3client = new AmazonS3Client(credentials);
    }
    
    public String guardarArchivo(File file, String nombreArchivo) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, nombreArchivo, file);
        putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        s3client.putObject(putObjectRequest);
        String url = "https://s3.amazonaws.com/" + bucketName + "/" + nombreArchivo;
        return url;
    }
    
    public String guardarArchivo(InputStream input, String nombreArchivo) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, nombreArchivo, input, new ObjectMetadata());
        putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        s3client.putObject(putObjectRequest);
        String url = "https://s3.amazonaws.com/" + bucketName + "/" + nombreArchivo;
        return url;
    }
    
    public void eliminarArchivo(String nombreArchivo) {
        s3client.deleteObject(new DeleteObjectRequest(bucketName, nombreArchivo));
    }
}
