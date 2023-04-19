package tests.utils;

import com.github.javafaker.Faker;
import tests.data.values.StateAndCity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

public class RandomUtils {

    static Faker faker = new Faker();
    static Calendar date = new GregorianCalendar();
    static StateAndCity[] values = StateAndCity.values();


    public static HashMap<String, String> statesAndCities = new HashMap<>();
    static {
        for (StateAndCity state : StateAndCity.values()) {
            statesAndCities.put(state.getState(), Arrays.toString(state.getCity()));
        }
    }

    public static String getRandomState() {
        return values[faker.random().nextInt(values.length)].getState();
    }

    public static String getRandomCity(String state) {
        String[] cities = statesAndCities.get(state).replace("[", "")
                .replace("]", "").replace(" ", "").split(",");
        return faker.options().option(cities);
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
        if(date.get(Calendar.MONTH) == Calendar.JANUARY) {
            return String.valueOf(Month.JANUARY);
        }
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
