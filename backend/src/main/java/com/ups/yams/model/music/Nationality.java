package com.ups.yams.model.music;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "nationalities")
public class Nationality {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String flag;

    public Nationality(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
