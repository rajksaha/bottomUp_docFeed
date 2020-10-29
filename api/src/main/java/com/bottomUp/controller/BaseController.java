package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.BottomUpUserDetail;
import com.bottomUp.domain.common.BaseData;
import com.itextpdf.text.DocumentException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.security.core.context.SecurityContextHolder;
import utility.DateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static String getURL(HttpServletRequest req) {

        String scheme = req.getScheme();             // http
        String serverName = req.getServerName();     // hostname.com
        int serverPort = req.getServerPort();        // 80
        String contextPath = req.getContextPath();   // /mywebapp
        //String servletPath = req.getServletPath();   // /servlet/MyServlet
        //String pathInfo = req.getPathInfo();         // /a/b;c=123
        //String queryString = req.getQueryString();          // d=789

        // Reconstruct original requesting URL
        StringBuilder url = new StringBuilder();
        url.append(scheme).append("://").append(serverName);

        if (serverPort != 80 && serverPort != 443) {
            url.append(":").append(serverPort);
        }

        url.append(contextPath);
        /*url.append(servletPath);

        if (pathInfo != null) {
            url.append(pathInfo);
        }
        if (queryString != null) {
            url.append("?").append(queryString);
        }*/
        return url.toString();

    }

    /**
     * build resultSet for pagination
     * @param list List of data
     * @param count total count of list
     * @return resultMap Map<String, Object>
     */
    public Map<String, Object> buildResultForGrid(List list, Integer count, Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Integer offset = param.get("offset") != null ? Integer.parseInt(param.get("offset").toString()) : 0;
        offset++; // change 0 based to 1 based
        if (CollectionUtils.isNotEmpty(list) && list.get(0) instanceof BaseData) {
            for (int i = 0; i < list.size(); i++) {
                BaseData object = (BaseData) list.get(i);
                object.setSerial(offset);
                offset++;
            }
        }
        resultMap.put("list", list);
        resultMap.put("count", count);
        return resultMap;
    }

    public void exportToExcel(HttpServletResponse response, Workbook wb, String reportName) throws BottomUpException, IOException {

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("Pragma", "No-cache");
        response.addHeader("Cache-control", "no-cache");
        response.addDateHeader("Expires",1 );
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", reportName);
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();
        wb.write(outStream);
        wb.close();

        // close what's open
        outStream.close();
    }

    public void exportToPdf(HttpServletResponse response, ByteArrayOutputStream baos, String reportName) throws BottomUpException, IOException, DocumentException {

        response.setContentLength(baos.size());
        response.setHeader("Expires", "0");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        // setting the content type
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", reportName);
        response.setHeader(headerKey, headerValue);


        OutputStream os = response.getOutputStream();
        baos.writeTo(os);
        os.flush();
        os.close();
    }
}
