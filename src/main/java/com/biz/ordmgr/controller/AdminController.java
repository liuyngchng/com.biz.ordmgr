package com.biz.ordmgr.controller;

import com.biz.ordmgr.auth.AuthPassport;
import com.biz.ordmgr.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页controller
 * @author Richard Liu
 * @version $Id$
 * @since 2017.03.31
 */
@Controller
@RequestMapping("common")
public final class AdminController {

    /**
     * Logger
     */
    private static final Logger LOGGER =
        LoggerFactory.getLogger(AdminController.class);

    /**
     * 可登录的用户.
     */
    private static final String[] userId = {
        "hQjbwmaOCaLH40p3vEa90Ncy"
    };

    private static final List<String> users = Arrays.asList(userId);


    /**
     * 用户权限列表.
     */
    public static final Map<String, List<String>> userBidChannelMap = new HashMap<String, List<String>>();

    static {
        userBidChannelMap.put(
            "hQjbwmaOCaLH40p3vEa90Ncy",
            Arrays.asList("1001", "1002", "1003", "1004", "1005", "1035",
                "1029", "1014", "1015", "1016")
        );
    }

    /**
     * 小狐后台主页.
     * @param request A {@link HttpServletRequest} instance
     * @return A string result
     */
    @AuthPassport
    @RequestMapping("index")
    public String index(final HttpServletRequest request) {
        return "common/index";
    }

    /**
     * 退出.
     * @param request A {@link HttpServletRequest} instance
     * @return A string result
     */
    @RequestMapping("logout")
    public String logout(final HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }

    @RequestMapping("login")
    public String login(final HttpServletRequest request,
        final HttpServletResponse response, final User user) {
        String context = request.getContextPath();
        LOGGER.info("context is {}", context);
        String returnPath;
        if ("GET".equals(request.getMethod())) {
            returnPath =  "/account/login";
        } else {
            LOGGER.info("user login, {}", user);
            if (this.checkUser(user)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(10 * 60);
                returnPath = "forward:" + "/common/index";
            } else {
                returnPath = "redirect:" + "/common/login";
            }
        }
        LOGGER.info("returnPath from login is {}", returnPath);
        return returnPath;
    }

    /**
     * 校验登录的用户是否合法.
     * @param user A {@link User} instance
     * @return 是否合法， true：合法， false：不合法
     */
    private boolean checkUser(final User user) {
        return users.contains(user.getUserName())
            && "admin".equals(user.getPassword());
    }
}
