package tests.utils;

import com.github.javafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static tests.data.values.IReferenceValues.*;

public class RandomUtils {

    static Faker faker = new Faker();
    static Random random = new Random();
    static Calendar date = new GregorianCalendar();


    public static String getRandomArrayString(String[] array) {
        return array[random.nextInt(array.length)];
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
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

    public static String getRandomSubjects() {
        return getRandomArrayString(SUBJECTS_ARR);
    }

    public static String getRandomGender() {
        return getRandomArrayString(GENDER_ARR);
    }

    public static String getRandomHobbies() {
        return getRandomArrayString(HOBBIES_ARR);
    }

    public static String getRandomState() {
        return getRandomArrayString(STATE_ARR);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                return getRandomArrayString(CITY_NCR);
            }
            case "Uttar Pradesh": {
                return getRandomArrayString(CITY_UTTAR_PRADESH);
            }
            case "Haryana": {
                return getRandomArrayString(CITY_HARYANA);
            }
            case "Rajasthan": {
                return getRandomArrayString(CITY_RAJASTHAN);
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

    public static Date getRandomDateBetween(String dateFrom, String dateTo) {
        String formatDate = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(formatDate);
        try {
            Date docDate1 = format.parse(dateFrom);
            Date docDate2 = format.parse(dateTo);
            date.setTime(faker.date().between(docDate1, docDate2));
            System.out.println(date.getTime());
            return date.getTime();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMontFromDate(Date dateT) {
        date.setTime(dateT);
        return String.valueOf(date.get(Calendar.MONTH));
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
