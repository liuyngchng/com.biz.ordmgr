package com.biz.ordmgr.model;

import java.util.Date;

public class Order {
    
    private String orderId;

    private String userId;

    private String mobile;

    private String homeLocId;

    private String workLocId;

    /**
     * GPs latitude;longitude;
     */
    private String location;

    /**
     * Some text for details.
     */
    private String desc;


    private Date createTime;

    /**
     * A db updateTime created automatically.
     */
    private Date updateTime;

}
