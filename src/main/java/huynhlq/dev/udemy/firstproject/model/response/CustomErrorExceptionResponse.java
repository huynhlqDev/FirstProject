package huynhlq.dev.udemy.firstproject.model.response;

import org.springframework.http.HttpStatus;

/// Class be created for format JSON response be "key: value"
/// example:
///     {
///         "identifier": "Duplicate entry '0001' for key 'project.Uem4so99ti26hmi35e2kyb'"
///     }
///
public class CustomErrorExceptionResponse {
    private String code;
    private String error;

    public CustomErrorExceptionResponse(String identifier) {
        this.code = String.valueOf(HttpStatus.BAD_REQUEST.value());
        this.error = identifier;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
