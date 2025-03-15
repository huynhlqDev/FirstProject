package huynhlq.dev.udemy.firstproject.model.response;

import org.springframework.http.HttpStatus;

/// Class be created for format JSON response be "key: value"
/// example:
///     {
///         "identifier": "Duplicate entry '0001' for key 'project.Uem4so99ti26hmi35e2kyb'"
///     }
///
public class IdExceptionResponse {
    private String code;
    private String identifier;

    public IdExceptionResponse(String identifier) {
        this.code = String.valueOf(HttpStatus.BAD_REQUEST.value());
        this.identifier = identifier;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
