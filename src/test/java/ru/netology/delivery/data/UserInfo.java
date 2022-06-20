package ru.netology.delivery.data;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserInfo {


    private final String city;
    private final String name;
    private final String phone;
}