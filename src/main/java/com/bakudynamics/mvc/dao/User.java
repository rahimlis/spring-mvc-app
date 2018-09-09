package com.bakudynamics.mvc.dao;

import javax.validation.constraints.*;
import java.util.Objects;

public class User {

    @NotBlank(message = "username cannot be blank")
    @Size(min = 4, max = 30, message = "username must be between 4 and 30 chars. ")
    @Pattern(regexp = "^\\w{4,}$", message = "username can only consists of numbers, letters and underscore symbol")
    private String username;

    @NotBlank
    @Pattern(regexp = "^\\S+$", message = "password should not contain spaces and blanks")
    @Size(min = 6, message = "Password mus be at least 6 symbols long")
    private String password;

    private boolean enabled = false;


    private String authority;

    @NotEmpty
    @Email
    private String email;

    @Size(min = 10, max = 100)
    private String name;


    public User() {

    }

    public User(String username, String name, String email, String password, boolean enabled, String authority) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                Objects.equals(username, user.username) &&
                Objects.equals(authority, user.authority) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authority='" + authority + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
