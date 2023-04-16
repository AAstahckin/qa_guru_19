package tests.selenide;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tests.page.PracticeFormPage;

import java.util.Calendar;
import java.util.Date;

import static tests.data.fields.IFieldsPracticeForm.*;
import static tests.utils.RandomUtils.*;

public class PracticeFormTest extends TestBase {
    Faker faker = new Faker();

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    Date randomDateBetween = getRandomDateBetween(1900, 2100);
    String
            firstNameValue = getRandomFirstName(),
            lastNameValue = getRandomLastName(),
            emailValue = getRandomEmail(),
            genderValue = getRandomGender(),
            phoneNumberValue = getRandomPhoneNumber(10),
            birthMonthValue = getMontFromDate(randomDateBetween),
            birthYearValue = getYearFromDate(randomDateBetween),
            birthDayValue = getDayFromDate(randomDateBetween),
            subjectsValue = getRandomSubjects(),
            hobbiesValue = getRandomHobbies(),
            currentAddressValue = getRandomAddress(),
            pictureValue = "wat.jpg",
            stateValue = getRandomState(),
            cityValue = getRandomCity(stateValue);

    @Test
    void successfulFormTest() {
        System.out.println(randomDateBetween);

        practiceFormPage
                .openPracticeForm()
                .checkFieldsNames()
                .setFirstName(firstNameValue)
                .setLastName(lastNameValue)
                .setUserEmail(emailValue)
                .setGender(genderValue)
                .setMobileNumber(phoneNumberValue)
                .setSubjects(subjectsValue)
                .setDateBirth(birthMonthValue, birthYearValue, birthDayValue)
                .setHobbies(hobbiesValue)
                .setAddress(currentAddressValue)
                .uploadFile(pictureValue)
                .setState(stateValue)
                .setCity(cityValue)
                .clickSubmit()
                .checkModalDialog()
                .verifyResults(FIELD_STUDENT_NAME, firstNameValue + " " + lastNameValue)
                .verifyResults(FIELD_STUDENT_EMAIL, emailValue)
                .verifyResults(FIELD_GENDER, genderValue)
                .verifyResults(FIELD_MOBILE, phoneNumberValue)
                .verifyResults(FIELD_DATE_BIRTH, birthDayValue + " " + birthMonthValue + "," + birthYearValue)
                .verifyResults(FIELD_SUBJECTS, subjectsValue)
                .verifyResults(FIELD_HOBBIES, hobbiesValue)
                .verifyResults(FIELD_PICTURE, pictureValue)
                .verifyResults(FIELD_ADDRESS, currentAddressValue)
                .verifyResults(FIELD_STATE_CITY, stateValue + " " + cityValue)
                .clickCloseSubmit();

    }

}
