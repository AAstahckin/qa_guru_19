package tests.utils;

import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

import static tests.data.values.IReferenceValues.*;

public class RandomUtils {

    static Faker faker = new Faker();
    static Calendar date = new GregorianCalendar();

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

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                return faker.options().option(CITY_NCR);
            }
            case "Uttar Pradesh": {
                return faker.options().option(CITY_UTTAR_PRADESH);
            }
            case "Haryana": {
                return faker.options().option(CITY_HARYANA);
            }
            case "Rajasthan": {
                return faker.options().option(CITY_RAJASTHAN);
            }
        }
        return null;
    }

    public static String getRandomPermanentAddress() {
        String city = faker.address().city();
        String street = faker.address().streetAddress();
        String streetAddressNumber = faker.address().streetAddressNumber();
        String buildingNumber = faker.address().buildingNumber();
        return city + " " + street + " " + streetAddressNumber + " " + buildingNumber;
    }

    public static Date getRandomDateBetween(int yearFrom, int yearTo) {
        String formatDate = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(formatDate);
        try {
            date.setTime(faker.date().between(
                    format.parse("01.01." + yearFrom),
                    format.parse("31.12." + yearTo)));
            return date.getTime();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMontFromDate(Date dateT) {
        date.setTime(dateT);
        return String.valueOf(Month.of(date.get(Calendar.MONTH)).plus(1));
    }

    public static String getYearFromDate(Date dateT) {
        date.setTime(dateT);
        return String.valueOf(date.get(Calendar.YEAR));
    }

    public static String getDayFromDate(Date dateT) {
        date.setTime(dateT);
        return String.valueOf(date.get(Calendar.DAY_OF_MONTH));
    }

}
