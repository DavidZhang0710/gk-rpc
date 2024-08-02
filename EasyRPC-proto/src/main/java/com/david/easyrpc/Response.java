package com.david.easyrpc;

import lombok.Data;

@Data
public class Response {
    private int code = 0;
    private String message = "ok";
    private Object data;
}
