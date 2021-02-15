package com.bottomUp.common.utility;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.model.AttachmentData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class BottomUpFileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BottomUpFileUtils.class);


    public static String getContentRootForImages() {

        String fullDir = System.getProperty("catalina.base");
        //String fullDir = "/home/mamun/Development/Tomcats/Tomcat7 FAMS";

        // content.root should have a separator
        String contentRoot = "/content";
        if (!contentRoot.startsWith(File.separator)) {
            fullDir += File.separator + "webapps" + File.separator + contentRoot;
        } else {
            fullDir += File.separator + "webapps" + contentRoot;
        }

        File file = new File(fullDir);
        if (!file.exists()) {
            file.mkdirs();
        }

        return fullDir;
    }

    public static String getContentRootForTempImages(String sessionID) {
        String path = getContentRootForImages() + File.separator + "temp" + File.separator + sessionID;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    public static boolean copyImage(File fileContent, File filePath) {
        try {
            org.apache.commons.io.FileUtils.copyFile(fileContent, filePath);
            return true;
        } catch (IOException ex) {
            LOGGER.error("error saving image", ex);
            return false;
        }
    }

    @Deprecated
    public static String saveFile(AttachmentData attachment) throws BottomUpException {

        String relativePath = "";
        String url = getContentRootForImages();
        if (!url.endsWith(File.separator)) {
            url += File.separator;
        }

        String filePath = url + attachment.getContentUrl();
        File tmpFile = retrieveFile(filePath);
        if (tmpFile.exists()) {

            relativePath = File.separator + "files" +
                    File.separator + attachment.getEntityType() +
                    File.separator + attachment.getEntityID() +
                    File.separator + attachment.getLabel() + "." + attachment.getFileType();
            String baseFilePath = getContentRootForImages() + relativePath;

            saveContentFile(tmpFile, baseFilePath);
            attachment.setContentUrl(relativePath);
            if (tmpFile.exists()) {
                tmpFile.delete();
            }
        }

        return relativePath;
    }

    public static boolean saveContentFile(File fileContent, String contentPath) {
        boolean flag = false;
        if (fileContent != null && fileContent.length() > 0 && contentPath != null && contentPath.length() > 0) {
            // contentDetail should contain file data and content url
            File filePath = new File(contentPath);
            if (filePath.exists()) {
                filePath.delete();
            }
            flag = copyImage(fileContent, filePath);
        }
        return flag;
    }

    public static File retrieveFile(String filePath) throws IllegalArgumentException {
        File file = null;
        try {
            /*String url = getContentRootForImages();
            if (!url.endsWith(File.separator)) {
                url += File.separator;
            }
            String fullFilePath = url + filePath;*/

            File tmpFile = new File(filePath);
            if (tmpFile.exists()) {
                file = tmpFile;
            } else {
                file = null;
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            LOGGER.error("Exception occurred while attempting to retrieve file", illegalArgumentException);
        }
        return file;
    }


}
