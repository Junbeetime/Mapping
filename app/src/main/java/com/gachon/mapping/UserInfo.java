package com.gachon.mapping;

public class UserInfo {
    public String uid;
    public String email;
    public String pwd;


    public UserInfo() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getUid(){
        return uid;
    }

    public void setPwd(String Pwd){
        this.pwd = Pwd;
    }

    public String getPwd(){
        return pwd;
    }


    public void setUid(String Uid){
        this.uid = Uid;
    }

    public UserInfo(String Email ,String Pwd) {
        this.email = Email;
        this.pwd = Pwd;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                ", EMAIL='" + email + '\'' +
                ", Password='" + email + '\'' +
                '}';
    }
}
