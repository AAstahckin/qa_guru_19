package tests.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static tests.data.values.IReferenceValues.*;

public class RandomUtils {

    static Faker faker = new Faker();
    static Random random = new Random();

    public static String getRandomArrayString(String[] array){
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

    public static String getRandomPhoneNumber() {
        return faker.numerify("##########");
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomMonth() {
        return String.valueOf(Month.of(faker.random().nextInt(13)));
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

    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1900, 2100));
    }

    public static String getRandomDay() {
        return String.valueOf(getRandomInt(1, 28));
    }

}
