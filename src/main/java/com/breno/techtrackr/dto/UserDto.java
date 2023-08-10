package com.breno.techtrackr.dto;

// import com.breno.techtrackr.model.UserRole;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDto {

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 92, message = "Name must be lower than 92 characters long")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Size(max = 62, message = "Email must be lower than 62 characters long")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @NotEmpty(message = "Bio cannot be empty")
    @Size(max = 112, message = "Bio must be lower than 112 characters long")
    private String bio;

    @NotEmpty(message = "Contact cannot be empty")
    @Size(max = 62, message = "Contact must be lower than 62 characters long")
    private String contact;

    @NotEmpty(message = "Module cannot be empty")
    @Pattern(regexp = "(PrimeiroModulo|SegundoModulo|TerceiroModulo|QuartoModulo|QuintoModulo|SextoModulo)", message = "User module must be PrimeiroModulo, SegundoModulo, TerceiroModulo, QuartoModulo, QuintoModulo or SextoModulo")
    private String module;

    @NotEmpty(message = "Role cannot be empty")
    @Pattern(regexp = "(USER|ADMIN)", message = "User role must be ADMIN or USER")
    private String role;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
