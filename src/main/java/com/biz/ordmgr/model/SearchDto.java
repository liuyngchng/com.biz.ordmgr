package com.biz.ordmgr.model;

import java.util.List;

/**
 * 查询dto
 * Created by Each.Zhang on 16/11/18.
 */
public final class SearchDto {
    /**
     * 产品类型.
     */
    private String loanType;

    /**
     * 产品渠道.
     */
    private String bidChannel;

    /**
     * 申请时间-开始.
     */
    private String applyBegin;

    /**
     * 申请时间-结束.
     */
    private String applyEnd;

    /**
     * 授信状态.
     */
    private String auditStatus;

    /**
     * 订单状态.
     */
    private String importStatus;

    /**
     * 身份证or手机号.
     */
    private String idOrMobile;

    /**
     * 订单ID.
     */
    private String fkLoanNo;

    /**
     * 订单id.
     */
    private String applyNo;

    /**
     * 第三方订单id.
     */
    private String partnerApplyNo;

    /**
     * 页码.
     */
    private Integer pageNo;

    /**
     * 每页数量.
     */
    private Integer pageSize;

    /**
     * 交易类型.
     */
    private String tradeType;

    /**
     * 审核结果.
     */
    private String riskReturnReason;

    /**
     * 业务类型编码.
     */
    private String businessNum;

    /**
     * 订单状态.
     */
    private String bizStatus;

    /**
     * 渠道订单编号.
     */
    private String partnerNo;

    /**
     * 是否允许放款，1：允许，0：不允许.
     */
    private String approveCharge;

    /**
     * 允许放款时间.
     */
    private String approveTimeBegin;

    /**
     * 允许放款时间.
     */
    private String approveTimeEnd;

    /**
     * 第三方订单ID列表.
     */
    private List<String> thirdOrderIdList;
}
