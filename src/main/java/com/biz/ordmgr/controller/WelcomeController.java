package com.biz.ordmgr.controller;

import com.biz.ordmgr.auth.AuthPassport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 根目录.
 * @author Richard Liu
 * @version $Id$
 * @since 2017.03.31
 */
@Controller
public final class WelcomeController {

    /**
     * 后台主页.
     * @param request A {@link HttpServletRequest} instance
     * @return A string result
     */
    @AuthPassport
    @RequestMapping("/")
    public String index(final HttpServletRequest request) {
        return "forward:common/login";
    }

}
