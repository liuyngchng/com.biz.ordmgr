package com.biz.ordmgr.controller;

import com.biz.ordmgr.auth.AuthPassport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 统一进件进件申请查询.
 * @author Richard Liu(liuyongcheng@souyidai.com)
 * @version $Id$
 * @since 2016.12.8
 */
@Controller
@RequestMapping("comimport")
public final class OrderInfoController {

    /**
     * Logger.
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrderInfoController.class);


    /**
     * 进件查询页面.
     * @param request {@link HttpServletRequest} instance.
     * @return A string of view path.
     */
    @AuthPassport
    @RequestMapping("import")
    public ModelAndView getImportInfo(final HttpServletRequest request) {
        LOGGER.info("start getImportInfo");
        final ModelAndView mv = new ModelAndView("comimport/import");
        return mv;
    }

}
