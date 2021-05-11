package com.test;

import java.io.Serializable;

/**
 * @author user
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userName;
    private String passWord;

    private User(Builder builder) {
        setId(builder.id);
        setUserName(builder.userName);
        setPassWord(builder.passWord);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(User copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.userName = copy.getUserName();
        builder.passWord = copy.getPassWord();
        return builder;
    }

    public User(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", passWord='" + passWord + '\'' +
            '}';
    }

    public static final class Builder {
        private Integer id;
        private String userName;
        private String passWord;

        private Builder() {
        }

        public Builder setId(Integer val) {
            id = val;
            return this;
        }

        public Builder setUserName(String val) {
            userName = val;
            return this;
        }

        public Builder setPassWord(String val) {
            passWord = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
