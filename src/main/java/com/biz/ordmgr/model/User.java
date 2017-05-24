package com.biz.ordmgr.model;

import java.io.Serializable;

/**
 * 用户.
 * @author Richard Liu
 * @version $Id$
 * @since 2017.03.30
 */
public final class User implements Serializable {

    private static final long serialVersionUID = 5182763482107666858L;
    /**
     * User name.
     */
    private String userName;

    /**
     * Password.
     */
    private transient String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
