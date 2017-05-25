package com.biz.ordmgr.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.biz.ordmgr.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Health check.
 * @author Richard Liu (liuyoungcheng@huli.com)
 * @version $Id$
 * @since 2017.03.30
 */
@Controller
@RequestMapping("health")
public final class HealthCheckController {

    /**
     * Constance.
     */
    private static final String HEALTH_CHECK_OK = "this is a test web for mobiusbiz";

    /**
     * 健康检查
     * @return 健康检查结果
     */
    @RequestMapping("check")
    @ResponseBody
    public Object health() {
        final Response response = new Response();
        response.setData(HEALTH_CHECK_OK);
        response.setErrorCode(0);
        return JSON.toJSONString(response);
    }

}
