package com.ups.yams.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "styles")
public class Style {
    @NotNull
    @NotEmpty
    private String name;

    private String description;

    public Style(){}

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
}
