package common;

public class Result<T> {

    private final Status status;
    private final String msg;
    private final T data;

    public Result(Status status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private Status getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }


    public static <T> Result<T> success(String okMsg, T data) {
        return new Result<>(Status.SUCCESS, okMsg, data);
    }


    public static <T> Result<T> fail(String failMsg, T data) {
        return new Result<>(Status.FAIL, failMsg, data);
    }

    public static <T> Result<T> cancel(String cancelMsg, T data) {
        return new Result<>(Status.CANCEL, cancelMsg, data);
    }

    public static <T> Result<T> inProgress(String progressMsg, T data) {
        return new Result<>(Status.IN_PROGRESS, progressMsg, data);
    }

    public static <T> Result<T> wait(String waitMsg) {
        return new Result<>(Status.WAIT, waitMsg, null);
    }

    public static <T> Result<T> wait(String waitMsg, T data) {
        return new Result<>(Status.WAIT, waitMsg, data);
    }

    public boolean isSuccess() {
        return status == Status.SUCCESS;
    }

    public boolean isFail() {
        return status == Status.FAIL;
    }

    public boolean isCancel() {
        return status == Status.CANCEL;
    }
    public boolean isWait() {
        return status == Status.WAIT;
    }
    public boolean isInProgress() {return status == Status.IN_PROGRESS;}




}
