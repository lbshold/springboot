package top.lconcise.business.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回参数
 *
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 783015033603078674L;

    private int code;
    private String msg;
    private T data;

    public static Result ok() {
        return new Result(ResultCode.SUCCESS, "");
    }

    public static Result ok(Object o) {
        return new Result(ResultCode.SUCCESS, o);
    }

    public static Result ok(String msg) {
        Result result = new Result(ResultCode.SUCCESS, "");
        result.setMsg(msg);
        return result;
    }


    public static Result failure(ResultCode code) {
        Result result = new Result(code);
        return result;
    }

    public static Result failure(ResultCode code, Object o) {
        return new Result(code, o);
    }

    public static Result failure(ResultCode code, String msg) {
        Result result = new Result(code);
        result.setMsg(msg);
        return result;
    }


    public Result(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    public Result(ResultCode resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":\"" + data + '\"' +
                '}';
    }
}
