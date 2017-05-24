package com.biz.ordmgr.enums;


import org.apache.commons.lang.enums.EnumUtils;

import java.util.ListIterator;

/**
 * 省份代码和省份名称对应关系.
 * Created by Each.Zhang on 16/11/14.
 * @author Richard Liu
 * @version $Id$
 * @since 2016.11.14
 */
public enum ProvinceCollection {

    /**北京*/
    BJ("11", "北京"),

    /**天津*/
    TJ("12", "天津"),

    /**河北*/
    HEB("13", "河北"),

    /**山西*/
    SHANX("14", "山西"),

    /**内蒙古*/
    NMG("15", "内蒙古"),

    /**辽宁*/
    LN("21", "辽宁"),

    /**吉林*/
    JL("22", "吉林"),

    /**黑龙江*/
    HLJ("23", "黑龙江"),

    /**上海*/
    SH("31", "上海"),

    /**江苏*/
    JS("32", "江苏"),

    /**浙江*/
    ZJ("33", "浙江"),

    /**安徽*/
    AH("34", "安徽"),

    /**福建*/
    FJ("35", "福建"),

    /**江西*/
    JX("36", "江西"),

    /**山东*/
    SD("37", "山东"),

    /**河南*/
    HAIN("41", "河南"),

    /**湖北*/
    HB("42", "湖北"),

    /**湖南*/
    HUN("43", "湖南"),

    /***/
    GD("44", "广东"),

    /**广东*/
    GX("45", "广西"),

    /**海南*/
    HN("46", "海南"),

    /**重庆*/
    CQ("50", "重庆"),

    /**四川*/
    SC("51", "四川"),

    /**贵州*/
    GZ("52", "贵州"),

    /**云南*/
    YN("53", "云南"),

    /**西藏*/
    XZ("54", "西藏"),

    /***/
    SX("61", "陕西"),

    /***/
    GS("62", "甘肃"),

    /***/
    QH("63", "青海"),

    /***/
    NX("64", "宁夏"),

    /***/
    XJ("65", "新疆"),

    /***/
    TW("71", "台湾"),

    /***/
    XG("81", "香港"),

    /***/
    AM("82", "澳门");

    /**
     * Province code.
     */
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Province name.
     */
    private String name;

    /**
     * Constructor.
     * @param cod Province cod
     * @param nam Province nam
     */
    ProvinceCollection(final String cod, final String nam) {
        this.code = cod;
        this.name = nam;
    }

    /**
     * 通过code查询Province name.
     * @param code Province code
     * @return Province name
     */
    public static String getNameByCode(final String code) {
        ListIterator<ProvinceCollection> itrList =
            EnumUtils.getEnumList(ProvinceCollection.class).listIterator();
        while (itrList.hasNext()) {
            ProvinceCollection collectionName = itrList.next();
            if (collectionName.code.equals(code)) {
                return collectionName.getName();
            }
        }
        return "";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
