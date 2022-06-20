package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerate {


    private DataGenerate() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return date;
    }

    public static String generateCity() {
        Random rnd = new Random();
        String[] array = {"Санкт-Петербург", "Москва", "Липецк", "Курск"};

        String city = array[rnd.nextInt(2)];
        return city;
    }


    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

@UtilityClass
    public static class Registration {
        public static UserInfo generateInfo() {
            String name = generateName();
            String phone = generatePhone();
            String city = generateCity();
            UserInfo info = new UserInfo(city, name, phone);
            return info;
        }
    }

}
