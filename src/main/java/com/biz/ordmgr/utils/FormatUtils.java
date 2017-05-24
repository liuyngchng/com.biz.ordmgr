package com.biz.ordmgr.utils;

import com.biz.ordmgr.enums.ProvinceCollection;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Each.Zhang on 16/11/11.
 */
public final class FormatUtils {
    private static final Logger LOG = LoggerFactory.getLogger(FormatUtils.class);
    /**
     * Excel导出格式化时间
     * @param date 时间日期
     * @return 格式化后时间日期yyyy-mm-dd hh:mm:ss
     */
    public static String ExcelDateFormat(final String date) {
        try {
            if(StringUtils.isNotBlank(date)) {
                StringBuilder sb = new StringBuilder(date);
                /**
                 * 畅游的时间不用格式化,是yyyy-mm-dd
                 */
                if (sb.length() != 14) {
                    return sb.toString();
                } else {
                    sb.insert(4, "-");
                    sb.insert(7, "-");
                    sb.insert(10, " ");
                    sb.insert(13, ":");
                    sb.insert(16, ":");
                    return sb.toString();
                }
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException e) {
            LOG.error("StringIndexOutOfBoundsException {}", e);
            return "";
        }

    }

    /**
     * 身份证脱敏
     * @param idNo 身份证号
     * @return 脱敏身份证号
     */
    public static String idEliminateSensitive(final String idNo) {
        try {
            if(StringUtils.isNotBlank(idNo)) {
                StringBuilder sb = new StringBuilder(idNo);
                if (sb.length() == 18) {
                    sb.replace(3, 6, "***");
                    sb.replace(14, 16, "**");
                } else if (sb.length() == 15) {
                    sb.replace(3, 6, "***");
                    sb.replace(12, 14, "**");
                } else {
                    return "";
                }
                return sb.toString();
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException e) {
            LOG.error("StringIndexOutOfBoundsException {}", e);
            return "";
        }
    }

    /**
     * 手机号脱敏
     * @param mobile 手机号
     * @return 脱敏手机号
     */
    public static String mobileEliminateSensitive(final String mobile) {
        try {
            if(StringUtils.isNotBlank(mobile)) {
                StringBuilder sb = new StringBuilder(mobile);
                sb.replace(3, 7, "****");
                return sb.toString();
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException e) {
            LOG.error("StringIndexOutOfBoundsException {}", e);
            return "";
        }
    }

    /**
     * 根据身份证取得生日
     * @param idNo 身份证号
     * @return 生日 yyyymmdd
     */
    public static String getBirthdayById(final String idNo) {
        try {
            if(StringUtils.isNotBlank(idNo)) {
                StringBuilder sb = new StringBuilder(idNo);
                if (sb.length() == 18) {
                    sb.delete(0, 6);
                    sb.deleteCharAt(8);
                    sb.deleteCharAt(8);
                    sb.deleteCharAt(8);
                    sb.deleteCharAt(8);
                    sb.insert(4, "-");
                    sb.insert(7, "-");
                } else if (sb.length() == 15) {
                    sb.delete(0, 6);
                    sb.insert(0, '1');
                    sb.insert(1, '9');
                    sb.deleteCharAt(8);
                    sb.deleteCharAt(8);
                    sb.deleteCharAt(8);
                    sb.insert(4, "-");
                    sb.insert(7, "-");
                } else {
                    return "";
                }
                return sb.toString();
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException e) {
            LOG.error("StringIndexOutOfBoundsException {}", e);
            return "";
        }
    }

    /**
     * 根据身份证号取得性别
     * @param idNo 身份证号
     * @return 性别,男/女
     */
    public static String getSexById(final String idNo) {
        if(StringUtils.isNotBlank(idNo)) {
            StringBuilder sb = new StringBuilder(idNo);
            if (sb.length() == 18) {
                if (sb.charAt(16)%2 == 0) {
                    return "女";
                } else {
                    return "男";
                }
            } else if (sb.length() == 15) {
                if (sb.charAt(14)%2 == 0) {
                    return "女";
                } else {
                    return "男";
                }
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    /**
     * 银行卡号脱敏
     * @param cardNo 银行卡号
     * @return 脱敏银行卡号
     */
    public static String bankCardEliminateSensitive(final String cardNo) {
        try {
            if(StringUtils.isNotBlank(cardNo)) {
                StringBuilder sb = new StringBuilder(cardNo);
                sb.replace(4, 12, "********");
                return sb.toString();
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException e) {
            LOG.error("StringIndexOutOfBoundsException {}", e);
            return "";
        }
    }

    /**
     * 钱 分转元
     * @param num 钱 分
     * @return 钱 元
     */
    public static String FenToYuan(final Long num) {
        if (num != null) {
            double num_double = (double)num;
            return String.valueOf(num_double/100);
        } else {
            return "";
        }
    }

    /**
     * 根据身份证号取得省份
     * @param idNo 身份证号
     * @return 省份
     */
    public static String getProvinceById(final String idNo) {
        try {
            if (StringUtils.isNotBlank(idNo)) {
                StringBuilder sb = new StringBuilder(idNo);
                String province = ProvinceCollection.getNameByCode(sb.substring(0, 2).toString());
                return province;
            } else {
                return "";
            }
        } catch (StringIndexOutOfBoundsException e) {
            LOG.error("StringIndexOutOfBoundsException {}", e);
            return "";
        }
    }

}
