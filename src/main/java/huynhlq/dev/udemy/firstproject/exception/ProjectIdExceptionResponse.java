package huynhlq.dev.udemy.firstproject.exception;

/// Class be created for format JSON response be "key: value"
/// example:
///     {
///         "identifier": "Duplicate entry '0001' for key 'project.Uem4so99ti26hmi35e2kyb'"
///     }
///
public class ProjectIdExceptionResponse {
    private String identifier;

    public ProjectIdExceptionResponse(String identifier) {
        this.identifier = identifier;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
