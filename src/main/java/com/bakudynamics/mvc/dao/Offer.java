package com.bakudynamics.mvc.dao;

import com.bakudynamics.mvc.validation.ValidAge;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class Offer {
    private int id;


    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @ValidAge
    private Date birthday;


    private User user;


    @NotBlank
    private String text;

    public Offer() {
        user = new User();
    }

    public Offer(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Offer(String text, Date birthday) {
        this.text = text;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(user, offer.user) &&
                Objects.equals(text, offer.text);
    }


    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}
