package com.bottomUp.common.contex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by raj on 7/25/2020.
 */
@Component
public class AppContextManager implements ApplicationContextAware {
    private static ApplicationContext _appCtx;

    public void setApplicationContext(ApplicationContext ctx){
        _appCtx = ctx;
    }

    public static ApplicationContext getAppContext(){
        return _appCtx;
    }
}

