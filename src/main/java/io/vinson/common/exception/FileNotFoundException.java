package io.vinson.common.exception;

public class FileNotFoundException extends CommonRuntimeException {
    private static final long serialVersionUID = -1L;

    public FileNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public FileNotFoundException(String msg) {
        super(msg);
    }
}
