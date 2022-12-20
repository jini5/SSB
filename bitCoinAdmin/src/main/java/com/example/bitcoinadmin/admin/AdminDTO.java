package com.example.bitcoinadmin.admin;

public class AdminDTO {

    private String Id;
    private String password;

    public AdminDTO(String id, String password) {
        Id = id;
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "Id='" + Id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
