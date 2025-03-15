package huynhlq.dev.udemy.firstproject.model.response;

import huynhlq.dev.udemy.firstproject.model.dto.UserDTO;

public class LoginResponseData {
    public String token;
    public UserDTO user;

    public LoginResponseData(String token, UserDTO user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
