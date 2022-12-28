package com.example.demoxenium.member.dto;

public class Member {

    private String id;
    private String pw;
    private String name;
    private String postcode;
    private String phone;
    private String address;
    private String addressDetail;
    private String email;
    private String gender;
    private String sns;
    private String birth;

    public Member(String id, String pw, String name, String postcode, String phone, String address, String addressDetail, String email, String gender, String sns, String birth) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.postcode = postcode;
        this.phone = phone;
        this.address = address;
        this.addressDetail = addressDetail;
        this.email = email;
        this.gender = gender;
        this.sns = sns;
        this.birth = birth;
    }

    public Member() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getSns() {
        return sns;
    }

    public String getBirth() {
        return birth;
    }
}
