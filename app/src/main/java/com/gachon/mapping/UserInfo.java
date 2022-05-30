package com.gachon.mapping;

public class UserInfo {
    public String uid;
    public String email;



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

    public void setUid(String Uid){
        this.uid = Uid;
    }

    public UserInfo(String Uid, String Email) {
        this.uid = Uid;
        this.email = Email;
    }



    @Override
    public String toString() {
        return "UserInfo{" +
                "UID='" + uid + '\'' +
                ", EMAIL='" + email + '\'' +
                '}';
    }
}
