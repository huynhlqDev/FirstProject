package huynhlq.dev.udemy.firstproject.model.response;

/**
 * Copyright © 2025 HuynhLQ. All rights reserved.
 * <p>
 * Author: HuynhLQ
 * Created: 15/3/25
 **/

public class LoginResponse extends BaseResponse<LoginResponseData> {
    public LoginResponse(String code, LoginResponseData result) {
        super(code, result);
    }
}
