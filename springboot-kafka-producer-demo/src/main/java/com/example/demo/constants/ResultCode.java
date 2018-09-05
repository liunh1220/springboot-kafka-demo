package com.example.demo.constants;

/**
 * Created by liulanhua on 2018/8/31.
 */
public enum ResultCode {

    SUCCESS("success","成功"),
    FAIL("fail","失败"),
    EXCEPTION("exception","异常");

    private String code;
    private String desc;

    private ResultCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
