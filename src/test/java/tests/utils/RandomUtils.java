package tests.utils;

import com.github.javafaker.Faker;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import static tests.data.values.StateAndCityPracticeForm.statesAndCities;

public class RandomUtils {

    static Faker faker = new Faker();
    static List<File> listFiles = Arrays.asList(new File("src/test/resources").listFiles());

    public static String getRandomState() {
        return faker.options().option(statesAndCities.keySet().toArray()).toString();
    }

    public static String getRandomCity(String state) {
        return faker.options().option(statesAndCities.get(state));
    }

    public static String getRandomFullName() {
        return faker.name().fullName();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber(int phoneNumberLength) {
        return faker.number().digits(phoneNumberLength);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomItemArray(String[] array) {
        return faker.options().option(array);
    }

    public static String getRandomPermanentAddress() {
        String city = faker.address().city();
        String street = faker.address().streetAddress();
        String streetAddressNumber = faker.address().streetAddressNumber();
        String buildingNumber = faker.address().buildingNumber();
        return city + " " + street + " " + streetAddressNumber + " " + buildingNumber;
    }

    public static String getRandomFile() {
        return listFiles.get(faker.random().nextInt(listFiles.size())).getName();
    }

    public static String[] getRandomDateBetween(int yearFrom, int yearTo) {
        String formatDate = "dd MMMM yyyy";
        return new SimpleDateFormat(formatDate, Locale.ENGLISH).format(faker.date().birthday(yearFrom, yearTo)).split(" ");
    }

    public static String getMontFromDate(String[] date) {
        return date[1];
    }

    public static String getYearFromDate(String[] date) {
        return date[2];
    }

    public static String getDayFromDate(String[] date) {
        return date[0];

    }

}
