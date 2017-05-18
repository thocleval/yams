package com.ups.yams.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Document(collection = "users")
public class User {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    private String profilePicture;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String coverPicture) {
        this.profilePicture = coverPicture;
    }
}
