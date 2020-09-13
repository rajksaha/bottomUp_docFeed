package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.BottomUpUserDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Handles requests for the application initial context datas.
 */
@Controller
public class ApplicationController extends BaseController {

/*    @Autowired
    private UserService  userService;*/

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(value = {"/application/data"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAppData(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> result = new HashMap<String, Object>();

        BottomUpUserDetail userDetail = this.getUserDetail();

        Collection<GrantedAuthority> permissions = userDetail.getAuthorities();
        Iterator<GrantedAuthority> it = permissions.iterator();
        Map<String, Boolean> perm = new HashMap<String, Boolean>();
        while (it.hasNext()) {
            String key = it.next().toString();
            perm.put(key, true);
        }
        userDetail.getUserProfilePermissionData().setPermissions(perm);
        result.put("userData",userDetail.getUserProfilePermissionData());
        return result;
    }


}
