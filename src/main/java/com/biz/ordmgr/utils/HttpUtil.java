package com.biz.ordmgr.utils;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Get remote IP address from http request.
 * @author Richard Liu (liuyongcheng@souyidai.com)
 * @version $Id$
 * @since 2016.09.13
 */
public final class HttpUtil {

    /**
     * Unknown constant.
     */
    private static final String UNKNOWN = "unknown";

    /**
     * Forward for constant.
     */
    private static final String FORWARD = "X-Forwarded-For";

    /**
     * Real IP constant.
     */
    private static final String REAL_IP = "X-Real-IP";
    public static final int INITIAL_CAPACITY = 8;

    /**
     * Make constructor private.
     */
    private HttpUtil() {
    }

    /**
     * Get Remote Ip address.
     * @param request A {@link HttpServletRequest} instance.
     * @return A IP address.
     */
    public static String getAddress(final HttpServletRequest request) {
        String address = parseHeader(request);
        if (StringUtils.isBlank(address)
            || StringUtils.equalsIgnoreCase(address, HttpUtil.UNKNOWN)) {
            address = request.getRemoteAddr();
        }
        if (StringUtils.isNotBlank(address)
            && StringUtils.indexOf(address, ",") > 0) {
            address = StringUtils.split(address, ",")[0];
        }
        return address;
    }

    /**
     * 获取用户http请求Agent的相关信息.
     * @param request A {@link HttpServletRequest} instance.
     * @return A string of header info.
     */
    public static String getHeader(final HttpServletRequest request) {
        final Enumeration<String> enumeration = request.getHeaderNames();
        final Map<String, String> headers =
            new HashMap<String, String>(HttpUtil.INITIAL_CAPACITY);
        while (enumeration.hasMoreElements()) {
            String value = enumeration.nextElement();
            headers.put(value, request.getHeader(value));
        }
        return JSON.toJSONString(headers);
    }

    /**
     * Get ip address from header.
     * @param request A {@link HttpServletRequest} instance.
     * @return A String represent IP.
     */
    private static String parseHeader(final HttpServletRequest request) {
        String address;
        address = request.getHeader(HttpUtil.FORWARD);
        if (null == address || address.isEmpty()) {
            address = request.getRemoteAddr();
        }
        if (StringUtils.isBlank(address)
            || StringUtils.equalsIgnoreCase(address, "")) {
            address = request.getHeader(HttpUtil.REAL_IP);
            if (null == address || address.isEmpty()) {
                address = request.getRemoteAddr();
            }
        }
        return address;
    }
}
