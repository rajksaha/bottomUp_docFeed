package com.bottomUp.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by raj on 11/13/2016.
 */
public class SessionTimeoutSetter implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        event.getSession().setMaxInactiveInterval(30000);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("if destroy");
    }
}