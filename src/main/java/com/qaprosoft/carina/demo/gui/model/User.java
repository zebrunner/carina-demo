package com.qaprosoft.carina.demo.gui.model;

import java.util.Objects;

public class User {
    private String nickName;
    private String email;
    private String password;
    private String wrongEmail;
    private String wrongPassword;

    public User(String nickName, String email, String password, String wrongEmail, String wrongPassword) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.wrongEmail = wrongEmail;
        this.wrongPassword = wrongPassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getWrongEmail() {
        return wrongEmail;
    }

    public void setWrongEmail(String wrongEmail) {
        this.wrongEmail = wrongEmail;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public void setWrongPassword(String wrongPassword) {
        this.wrongPassword = wrongPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", wrongEmail='" + wrongEmail + '\'' +
                ", wrongPassword='" + wrongPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getNickName(), user.getNickName())
                && Objects.equals(getEmail(), user.getEmail())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getWrongEmail(), user.getWrongEmail())
                && Objects.equals(getWrongPassword(), user.getWrongPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNickName(), getEmail(), getPassword(),
                getWrongEmail(), getWrongPassword());
    }
}
