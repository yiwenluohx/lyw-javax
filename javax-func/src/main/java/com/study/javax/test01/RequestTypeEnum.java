package com.study.javax.test01;

import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 请求方式类型枚举
 *
 * @author luohx
 * @version 1.0.0
 * @date: 2023/8/10 下午3:07
 * @menu 请求方式类型枚举
 */
public enum RequestTypeEnum {

    GET_REQ(1, "GET请求"),

    PUT_REQ(2, "PUT请求");

    /**
     * code
     */
    private Integer code;

    /**
     * 备注
     */
    private String des;

    RequestTypeEnum(Integer code, String des) {
        this.code = code;
        this.des = des;
    }

    /**
     * Gets the value of code.
     *
     * @return the value of code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Sets the code. *
     * <p>You can use getCode() to get the value of code</p>
     * * @param code code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Gets the value of des.
     *
     * @return the value of des
     */
    public String getDes() {
        return des;
    }

    /**
     * Sets the des. *
     * <p>You can use getDes() to get the value of des</p>
     * * @param des des
     */
    public void setDes(String des) {
        this.des = des;
    }

    public static Supplier<List<Integer>> allCode = () -> Arrays.stream(RequestTypeEnum.values()).map(e -> e.getCode()).collect(Collectors.toList());

    public static Supplier<List<Integer>> settingCode = () -> Lists.newArrayList(RequestTypeEnum.PUT_REQ.code, RequestTypeEnum.GET_REQ.code);
}
