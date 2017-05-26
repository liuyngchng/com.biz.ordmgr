package com.biz.ordmgr.controller;

import com.alibaba.fastjson.JSON;
import com.biz.ordmgr.auth.AuthPassport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 订单订单申请查询.
 * @author Richard Liu(liuyongcheng@souyidai.com)
 * @version $Id$
 * @since 2016.12.8
 */
@Controller
@RequestMapping("order")
public final class OrderController {

    /**
     * Logger.
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("index")
    public ModelAndView orderIndex(final HttpServletRequest request) {
        LOGGER.info("orderIndex, parameter is {}", request.getParameterMap());
        ModelAndView modelAndView = new ModelAndView("static/index");
        return modelAndView;
    }

    @RequestMapping("save/work")
    @ResponseBody
    public String saveWork(final HttpServletRequest request) {
        LOGGER.info("saveWork, parameter is {}", request.getParameterMap());
        return "保存成功";
    }


}
