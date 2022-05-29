package com.gachon.mapping;

public class User {
    public String address;
    public String content;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String Address, String Content) {
        this.address = Address;
        this.content = Content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String email) {
        this.content = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
