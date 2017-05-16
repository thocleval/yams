package com.ups.yams.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

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
