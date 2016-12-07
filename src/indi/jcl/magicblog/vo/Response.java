package indi.jcl.magicblog.vo;

/**
 * Created by Magic Long on 2016/9/20.
 */
public class Response {
    public static final int SUCCESS = 10000;
    public static final int FAIL = -10000;
    public static final int EXCEPTION = -20000;
    private int code;
    private String msg;
    private Object result;


    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
