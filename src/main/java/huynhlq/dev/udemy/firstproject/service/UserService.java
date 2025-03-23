package huynhlq.dev.udemy.firstproject.service;

import huynhlq.dev.udemy.firstproject.model.dto.UserDTO;
import huynhlq.dev.udemy.firstproject.model.entity.User;
import huynhlq.dev.udemy.firstproject.model.request.RegisterRequest;

/**
 * Copyright © 2025 HuynhLQ. All rights reserved.
 * <p>
 * Author: HuynhLQ
 * Created: 16/3/25
 **/
public interface UserService {
    public UserDTO findByUsername(String username);
    public UserDTO save(RegisterRequest userRegis);
}
