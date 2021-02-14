package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.AmazonS3BucketService;
import com.bottomUp.common.utility.BottomUpFileUtils;
import com.bottomUp.model.AttachmentData;
import com.bottomUp.service.common.AttachmentService;
import com.bottomUp.service.docFeed.crud.PatientService;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by raj on 02/12/21.
 */

@Controller
@RequestMapping("attachment")
public class AttachmentController {


    private static final int BUFFER_SIZE = 4096;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void uploadImage(@RequestParam("file") MultipartFile multipart,
                            @RequestParam("extension") String extension,
                            @RequestParam("entityType") String entityType,
                            @RequestParam("entityID") Integer entityID,
                            @RequestParam("description") String description,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        Map<String, Object> object = new HashMap<String, Object>();

        String sessionID = request.getSession().getId();

        String url = BottomUpFileUtils.getContentRootForTempImages(sessionID);
        if (!url.endsWith(File.separator)) {
            url += File.separator;
        }
        UUID fileID = UUID.randomUUID();
        String filePath = url + fileID + "." + extension;

        File convFile = new File(filePath);
        multipart.transferTo(convFile);

        double size = 0;
        boolean status = true;
        if (convFile != null && convFile.length() > 0) {
            size = ((double) convFile.length() / (1024 * 1024));
            object.put("size", size);

            if (size > 5) {
                status = false;
                object.put("hasError", true);
                object.put("hasMaxSizeError", true);
            }

            // if its a valid image then write it into the system
            if (status) {
                //TODO if image file then put in image folder otherwise filefolder
                String imgUrl = "temp" + File.separator + sessionID + File.separator + fileID + "." + extension;

                imgUrl = imgUrl.replace("\\", "/");
                description = StringUtils.trimToEmpty(description);
                AttachmentData attachment = new AttachmentData();
                attachment.setDescription(description);
                attachment.setShortName(multipart.getOriginalFilename());
                attachment.setEntityType(entityType);
                attachment.setEntityID(entityID);
                attachment.setContentUrl(imgUrl);
                attachment.setLabel(fileID.toString());
                attachment.setFileType(extension);
                attachment.setStatus(1);

                object.put("message", "Uploaded successfully");
                object.put("attachment", attachment);
                object.put("success", true);
            }
        } else {

            object.put("message", "Upload failed");
            object.put("success", false);
            object.put("hasError", true);
        }

        response.getWriter().print(new Gson().toJson(object));
        response.getWriter().close();

    }

    @RequestMapping(value = {"getAll/entity/{entity}/entityId/{entityId}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AttachmentData> getAll(@PathVariable("entity") String entity, @PathVariable("entityId") Integer entityId) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("entityType", entity);
        params.put("entityId", entityId);

        List<AttachmentData> attachmentList = this.attachmentService.getAll(params);
        if (attachmentList == null) {
            attachmentList = new ArrayList<AttachmentData>();
        }
        return attachmentList;
    }


    @RequestMapping(value = {"save"}, method = RequestMethod.POST)
    @ResponseBody
    public AttachmentData save(@RequestBody AttachmentData attachment) throws BottomUpException {
        this.saveToStorage(attachment);
        return attachment;
    }

    @RequestMapping(value = {"savePatientImage"}, method = RequestMethod.POST)
    @ResponseBody
    public AttachmentData savePatientImage(@RequestBody AttachmentData attachment) throws BottomUpException {
        this.saveToStorage(attachment);
        this.patientService.updatePatientImage(Long.valueOf(attachment.getEntityID()), attachment.getContentUrl());
        return attachment;
    }

    private AttachmentData saveToStorage(AttachmentData attachment)throws BottomUpException{
        if (StringUtils.isNotBlank(attachment.getContentUrl())) {
            try {
                AmazonS3BucketService amazonS3BucketService = new AmazonS3BucketService();
                amazonS3BucketService.upload(attachment);
                this.attachmentService.create(attachment);

            }catch (Exception ex){
                System.out.println("ERROR:"  + ex.getMessage());
            }
        }

        return attachment;
    }

    @RequestMapping(value = {"delete/{attachmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public Boolean update(@PathVariable("attachmentID") Long attachmentID) throws BottomUpException {
        if (attachmentID != null && attachmentID > 0) {
            AttachmentData attachment = this.attachmentService.getByID(attachmentID);
            String contentPath = BottomUpFileUtils.getContentRootForImages();
            String filePath = contentPath + attachment.getContentUrl();
            File file = new File(filePath);
            FileUtils.deleteQuietly(file); // Delete file
            this.attachmentService.delete(attachmentID);

        }
        return true;
    }

    @RequestMapping(value = "/verify/{attachmentID}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> verify(@PathVariable("attachmentID") Long attachmentID) throws BottomUpException, IOException {
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("fileExist",false);

        AttachmentData attachment = this.attachmentService.getByID(attachmentID);
        String contentPath = BottomUpFileUtils.getContentRootForImages();
        String filePath = contentPath + attachment.getContentUrl();
        File file = new File(filePath);
        if(file.exists()){
            result.put("fileExist",true);
        }
        return result;
    }

    @RequestMapping(value = "/download/{attachmentId}", method = RequestMethod.GET)
    @ResponseBody
    public void getFile(@PathVariable("attachmentId") Long attachmentId, HttpServletRequest request, HttpServletResponse response) throws BottomUpException, IOException {
        AttachmentData attachment = this.attachmentService.getByID(attachmentId);
        String contentPath = BottomUpFileUtils.getContentRootForImages();
        String filePath = contentPath + attachment.getContentUrl();
        FileSystemResource file = new FileSystemResource(filePath);


        ServletContext context = request.getSession().getServletContext();
        File downloadFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        // get MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", attachment.getShortName());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

    }

}
