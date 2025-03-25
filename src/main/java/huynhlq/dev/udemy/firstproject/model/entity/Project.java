package huynhlq.dev.udemy.firstproject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import huynhlq.dev.udemy.firstproject.model.dto.ProjectDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Project identifier is required")
    @Size(min = 4, max = 5, message = "Size in 4 -> 5")
    @Column(updatable = false, unique = true)
    private String identifier;

    @NotBlank(message = "Project name is required")
    private String name;

    @NotBlank(message = "Project description is required")
    private String description;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date endDate;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date createdAt;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updatedAt;

    private boolean deleted;

    public Project() {
    }

    public Project(String identifier,
                   String name,
                   String description,
                   Date startDate,
                   Date endDate
    ) {
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createAt) {
        this.createdAt = createAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updateAt) {
        this.updatedAt = updateAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
