package com.gateszeng.sdhacks2016;

/**
 * Created by akanshadey on 10/1/16.
 */

public class EmergencyPost {

    String message = "";

    public EmergencyPost(String post) {
        message = post;
    }

    public String getMessage() { return message; }

    public void setMessage(String updatedMessage) { message = updatedMessage; }
}
