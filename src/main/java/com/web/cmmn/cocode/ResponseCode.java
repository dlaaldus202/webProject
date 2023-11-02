package com.web.cmmn.cocode;

public enum ResponseCode {
    S001("성공하였습니다."),
    E001("데이터가 없습니다."),
    E002("데이터가 맞지 않습니다.");

    private final String message;

    ResponseCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}