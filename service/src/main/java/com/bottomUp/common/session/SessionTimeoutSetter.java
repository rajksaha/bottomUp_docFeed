package com.bottomUp.common.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by raj on 7/25/2020.
 */
public class SessionTimeoutSetter implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(5);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        // not needed
    }
}