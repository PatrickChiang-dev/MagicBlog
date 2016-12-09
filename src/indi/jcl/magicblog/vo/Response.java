package indi.jcl.magicblog.vo;

import indi.jcl.magicblog.util.JsonUtil;

/**
 * Created by Magic Long on 2016/9/20.
 */
public class Response {
    private static final int SUCCESS = 10000;
    private static final int FAIL = -10000;
    private static final int EXCEPTION = -20000;

    private int code;
    private String msg;
    private Object result;

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Response SUCCESS() {
        return new Response(SUCCESS, "成功");
    }

    public static Response FAIL() {
        return new Response(FAIL, "失败");
    }

    public static Response EXCEPTION() {
        return new Response(EXCEPTION, "异常");
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

    public static void main(String[] args) {
        System.out.println(JsonUtil.getJsonString(Response.SUCCESS().setMsg("登录")));
        System.out.println(JsonUtil.getJsonString(Response.SUCCESS()));


    }
}
