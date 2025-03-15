package huynhlq.dev.udemy.firstproject.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Copyright © 2025 HuynhLQ. All rights reserved.
 * <p>
 * Author: HuynhLQ
 * Created: 15/3/25
 **/
public class UserDTO {
    private String username;
    private String fullName;
    private String createAt;
    private String updateAt;

    public UserDTO() {
    }

    public UserDTO(String username, String fullName, String createAt, String updateAt) {
        this.username = username;
        this.fullName = fullName;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
