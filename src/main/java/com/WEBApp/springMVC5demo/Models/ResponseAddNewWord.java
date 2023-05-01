package com.WEBApp.springMVC5demo.Models;

public class ResponseAddNewWord {
    private String responseMessage;

    public ResponseAddNewWord(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
