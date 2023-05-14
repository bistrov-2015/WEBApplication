package com.WEBApp.springMVC5demo.Models;

public class Message {
    private String resultMessage;

    public Message(){}
    public Message(String message) {
        this.resultMessage = message;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
