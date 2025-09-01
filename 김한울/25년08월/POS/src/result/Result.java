package result;

import util.Status;

public class Result<T> {

    private final Status status;
    private final String msg;
    private final T data;

    public Result(Status status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(Status.SUCCESS, "ok ", data);
    }

    public static <T> Result<T> success(String okMsg, T data) {
        return new Result<>(Status.SUCCESS, okMsg, data);
    }

    public static <T> Result<T> fail(T data) {
        return new Result<>(Status.FAIL, "fail", data);
    }

    public static <T> Result<T> fail(String failMsg, T data) {
        return new Result<>(Status.FAIL, failMsg, data);
    }

    public static <T> Result<T> cancel(T data) {
        return new Result<>(Status.FAIL, "cancel", data);
    }

    public static <T> Result<T> cancel(String cancelMsg, T data) {
        return new Result<>(Status.FAIL, cancelMsg, data);
    }


}
