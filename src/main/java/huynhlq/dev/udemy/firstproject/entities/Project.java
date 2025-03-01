package huynhlq.dev.udemy.firstproject.entities;

import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String identifier;
    private Date startDate;
    private Date endDate;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Project() {}

    @PrePersist
    protected void onCreate() {
        this.createAt = new Date();
        this.deleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
