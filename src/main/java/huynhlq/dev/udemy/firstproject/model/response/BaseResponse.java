package huynhlq.dev.udemy.firstproject.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Copyright © 2025 HuynhLQ. All rights reserved.
 * <p>
 * Author: HuynhLQ
 * Created: 15/3/25
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseResponse<T> {
    private String code;
    private T result;

    public BaseResponse() {
    }

    public BaseResponse(String code, T result) {
        this.code = code;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
