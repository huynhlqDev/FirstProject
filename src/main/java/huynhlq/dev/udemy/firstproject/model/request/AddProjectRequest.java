package huynhlq.dev.udemy.firstproject.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

/**
 * Copyright © 2025 HuynhLQ. All rights reserved.
 * <p>
 * Author: HuynhLQ
 * Created: 25/3/25
 **/
public class AddProjectRequest {
    @NotBlank(message = "Project identifier is required")
    @Size(min = 4, max = 5, message = "Size in 4 -> 5")
    private String identifier;
    @NotBlank(message = "Project name is required")
    private String name;
    @NotBlank(message = "Description name is required")
    private String description;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date endDate;

    @NotBlank(message = "Project name is required")
    private String ownerUsername;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerId) {
        this.ownerUsername = ownerId;
    }
}
