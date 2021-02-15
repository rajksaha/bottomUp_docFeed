package com.bottomUp.common.utility;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.model.AttachmentData;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raj on 2/13/2021.
 */
public class AmazonS3BucketService {

    private AmazonS3 amazonS3;
    private final String endpointUrl = "https://s3.cloudLocation.amazonaws.com";
    private final String bucketName = "docfeedimagebucket";

    public AmazonS3BucketService() {
        String secret, decodedBinarySecret;
        try {
            AWSCredentials credentials = new BasicAWSCredentials(System.getenv("AWS_ACCESS_KEY_ID"),
                    System.getenv("AWS_SECRET_ACCESS_KEY"));
            this.amazonS3 = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(Regions.AP_SOUTHEAST_1)
                    .build();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public String uploadMultipartFile(MultipartFile multipartFile) {
        String fileURL = "";
        try {
            File file = convertMultipartFileToFile(multipartFile);
            String fileName = multipartFile.getOriginalFilename();
            uploadFileToBucket(fileName, file);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileURL;
    }

    public void getObj()  {

        /*try {
            amazonS3.getObject(bucketName, objectName);
            S3ObjectInputStream inputStream = s3object.getObjectContent();
            FileUtils.copyInputStreamToFile(inputStream, new File(CommonConstants.LOCAL_DOWNLOAD_PATH));
            System.out.println("file copied to destination.");
        }catch(Exception e) {
            e.printStackTrace();
        }*/
    }

    private void createFolder(String bucketName, String folderName, String SUFFIX) {
        // create meta-data for your folder and set content-length to 0
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);

        // create empty content+
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

        // create a PutObjectRequest passing the folder name suffixed by /
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName + SUFFIX, emptyContent,
                metadata);

        // send request to S3 to create folder
        amazonS3.putObject(putObjectRequest);
    }

    public String uploadFile(File file, String fileName) {
        try {
            return uploadFileToBucket(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    private String uploadFileToBucket(String fileName, File file) {
        amazonS3.putObject(new PutObjectRequest(this.bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3.getUrl(this.bucketName, fileName).toString();
    }

    public String deleteFileFromBucket(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(this.bucketName, fileName));
        return "Deletion Successful";
    }

    public void upload(AttachmentData attachment) throws BottomUpException{
        File tmpFile = BottomUpFileUtils.retrieveFile(attachment.getContentUrl());
        String relativePath = attachment.getEntityType() +
                File.separator + attachment.getEntityID() +
                File.separator + attachment.getLabel() + "." + attachment.getFileType();
        String baseFilePath = this.uploadFile(tmpFile, relativePath);
        tmpFile.delete();
        attachment.setContentUrl(baseFilePath);

    }
}
