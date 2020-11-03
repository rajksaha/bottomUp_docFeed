package com.bottomUp.common.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by raj on 7/25/2020.
 */
public enum BottomUpProperties {
    INSTANCE;

    private Properties bottomUpProperties;
    private static final Logger log = LoggerFactory.getLogger(BottomUpProperties.class);

    BottomUpProperties() {
        init();
    }

    private void init() {
        try {
            //load two resource files
            Resource resource = new ClassPathResource("echo.properties");
            //load properties
            bottomUpProperties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            log.error("error loading echo.properties", ex);
        }
    }

    public String getProperty(String key) {
        return bottomUpProperties.getProperty(key);
    }

    public boolean getBooleanProperty(String key) {
        return Boolean.valueOf(bottomUpProperties.getProperty(key, "false"));
    }

    public int getNumericProperty(String key) {
        return Integer.valueOf(bottomUpProperties.getProperty(key, "0"));
    }

    public void refresh() {
        init();
    }
}
