package com.github.pioneer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @description: 脱敏相关
 * @date: 2018/6/27
 * @time: 下午3:45
 * All rights reserved
 */
public class DesensitizationUtil {

    /**
     * 地址脱敏
     *
     * @param value
     * @param replaceParam
     * @return
     */

    public static String replaceLetter(String value, String replaceParam) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher matcher = p.matcher(value);
        return matcher.replaceAll(replaceParam);
    }

    /**
     * 姓名脱敏
     *
     * @param address
     * @param sensitiveSize
     * @return
     */
    public static String replaceName(String address, int sensitiveSize) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, sensitiveSize), length, "*");
    }

    /**
     * 手机号码脱敏
     *
     * @param num
     * @return
     */
    public static String fixedPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(num, num.length() - 4), StringUtils.length(num), "*");
    }
}
