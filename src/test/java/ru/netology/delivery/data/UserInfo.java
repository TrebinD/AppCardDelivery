package ru.netology.delivery.data;


import lombok.Data;

@Data

public class UserInfo {


    private final String city;
    private final String name;
    private final String phone;

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    public UserInfo(String city, String name, String phone) {
        this.city = city;
        this.name = name;
        this.phone = phone;
    }
}