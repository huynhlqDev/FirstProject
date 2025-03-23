package huynhlq.dev.udemy.firstproject.model.request;

/**
 * Copyright © 2025 HuynhLQ. All rights reserved.
 * <p>
 * Author: HuynhLQ
 * Created: 16/3/25
 **/
public class RegisterRequest {
    private String username;
    private String password;
    private String fullName;

    RegisterRequest (String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
