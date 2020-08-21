package com.bottomUp.controller;

import com.bottomUp.domain.BottomUpUserDetail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raj on 7/26/2020.
 */
public class BaseController {

    public static String[] DATE_PARSE_PATTERN = {"MM/dd/yyyy", "MM-dd-yyyy", "MMddyyyy", "HHmmss"};
    public final DateFormat formatter = new SimpleDateFormat(DATE_PARSE_PATTERN[2]);
    public final DateFormat timeFormatter = new SimpleDateFormat(DATE_PARSE_PATTERN[3]);

    public BottomUpUserDetail getUserDetail() {
        return (BottomUpUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Map<String, Object> parseParameter(HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = (String) names.nextElement();
            if(StringUtils.isNotEmpty(request.getParameter(name))) {
                resultMap.put(name, request.getParameter(name));
            }
        }

        Integer page = Integer.parseInt((String) resultMap.get("page"));
        Integer limit = Integer.parseInt((String) resultMap.get("limit"));
        String sortColumn = (String) resultMap.get("sort");
        if(StringUtils.isEmpty(sortColumn)) sortColumn = "1";
        String sortOrder = (String) resultMap.get("sort_dir");
        Integer offset = (page - 1) * limit;

        // remove un-necessary param
        resultMap.remove("skip");
        resultMap.remove("page");
        resultMap.remove("sort_dir");
        resultMap.remove("sort");

        //put new params
        resultMap.put("sortColumn", sortColumn);
        resultMap.put("sortOrder", sortOrder);
        resultMap.put("offset", offset);
        resultMap.put("limit", limit);

        return resultMap;
    }
}