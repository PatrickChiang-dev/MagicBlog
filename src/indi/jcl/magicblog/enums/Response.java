package indi.jcl.magicblog.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by Magic Long on 2016/9/20.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Response {
    SUCCESS(10000, "成功"),
    FAIL(-10000, "失败"),
    EXCEPTION(-20000, "异常");

    private int code;
    private String msg;
    private Object result;

    Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }
    public String getMsg() {
        return msg;
    }

    public Response setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public Response setResult(Object result) {
        this.result = result;
        return this;
    }

}
