package com.superfast.messages;

/**
 * Created by waltersanchez on 8/17/18.
 */
public class PrintCompletedMessage {
    private String message;
    private long time;

    public PrintCompletedMessage(String message, long time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public long getTime() {
        return time;
    }
}
