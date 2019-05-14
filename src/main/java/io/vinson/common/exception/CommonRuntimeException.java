package io.vinson.common.exception;

import io.vinson.common.util.NestedExceptionUtils;

public class CommonRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -1L;
    private String reason;

    public CommonRuntimeException(String msg) {
        this(msg, "");
    }

    public CommonRuntimeException(String msg, Throwable cause) {
        this(msg, "", cause);
    }

    public CommonRuntimeException(String msg, String reason) {
        super(msg);
        this.reason = reason;
    }

    public CommonRuntimeException(String msg, String reason, Throwable cause) {
        super(msg, cause);
        this.reason = reason;
    }

    public String getReason() {
        return this.reason == null ? "" : this.reason;
    }

    public String getMessage() {
        return NestedExceptionUtils.buildMessage(super.getMessage(), this.getCause());
    }

}
