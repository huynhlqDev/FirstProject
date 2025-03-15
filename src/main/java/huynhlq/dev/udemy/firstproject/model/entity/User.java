package huynhlq.dev.udemy.firstproject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String fullName;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updatedAt;
    // Use flag for deletion
    private boolean deleted;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.deleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
