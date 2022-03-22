package com.onlineauction.onlineauctionservlet.model.beans;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {

    public enum type {
        ADMIN(2), BUYER(0), SELLER(1);

        private final int typeCode;
        private static final Map<Object, Object> map = new HashMap<>();

        type(int typeCode) {
            this.typeCode = typeCode;
        }

        static {
            for (type usertype : type.values()) {
                map.put(usertype.typeCode, usertype);
            }
        }

        public static type valueOf(int usertype) {
            return (type) map.get(usertype);
        }

        public int getValue() {
            return typeCode;
        }
    }

    private int userid;
    private String name;
    private LocalDate dob;
    private String email;
    private String phonenumber;
    private String username;
    private String password;
    private String address;
    private type usertype;
    private double wallet;

    public User() {
        super();
    }

    public User(int userid, String name, LocalDate dob, String email, String phonenumber, String username,
                String password, String address, type usertype, double wallet) {
        super();
        this.userid = userid;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phonenumber = phonenumber;
        this.username = username;
        this.password = password;
        this.address = address;
        this.usertype = usertype;
        this.wallet = wallet;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUserType() {
        return usertype.typeCode;
    }

    public void setUserType(int userType) {
        this.usertype = type.valueOf(userType);
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", name=" + name + ", dob=" + dob + ", email=" + email + ", phonenumber="
                + phonenumber + ", username=" + username + ", password=" + password + ", address=" + address
                + ", usertype=" + usertype + ", wallet=" + wallet + "]";
    }

}
