package tests.selenide;

import org.junit.jupiter.api.Test;
import tests.page.PracticeFormPage;

import java.util.Date;

import static tests.data.fields.FieldsPracticeForm.*;
import static tests.data.values.ArraysValuesPracticeForm.*;
import static tests.utils.RandomUtils.*;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void randomValuesPracticeFormTest() {

        Date randomDateBetween = getRandomDateBetween(1900, 2100);

        String
                firstNameValue = getRandomFirstName(),
                lastNameValue = getRandomLastName(),
                emailValue = getRandomEmail(),
                genderValue = getRandomItemArray(GENDER_ARR.getArrayValues()),
                phoneNumberValue = getRandomPhoneNumber(10),
                birthMonthValue = getMontFromDate(randomDateBetween),
                birthYearValue = getYearFromDate(randomDateBetween),
                birthDayValue = getDayFromDate(randomDateBetween),
                subjectsValue = getRandomItemArray(SUBJECTS_ARR.getArrayValues()),
                hobbiesValue = getRandomItemArray(HOBBIES_ARR.getArrayValues()),
                currentAddressValue = getRandomAddress(),
                pictureValue = "wat.jpg",
                stateValue = getRandomState(),
                cityValue = getRandomCity(stateValue);


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
                    .verifyResults(FIELD_STUDENT_NAME.getName(), firstNameValue + " " + lastNameValue)
                    .verifyResults(FIELD_STUDENT_EMAIL.getName(), emailValue)
                    .verifyResults(FIELD_GENDER.getName(), genderValue)
                    .verifyResults(FIELD_MOBILE.getName(), phoneNumberValue)
                    .verifyResults(FIELD_DATE_BIRTH.getName(), birthDayValue + " " + birthMonthValue + "," + birthYearValue)
                    .verifyResults(FIELD_SUBJECTS.getName(), subjectsValue)
                    .verifyResults(FIELD_HOBBIES.getName(), hobbiesValue)
                    .verifyResults(FIELD_PICTURE.getName(), pictureValue)
                    .verifyResults(FIELD_ADDRESS.getName(), currentAddressValue)
                    .verifyResults(FIELD_STATE_CITY.getName(), stateValue + " " + cityValue)
                    .clickCloseSubmit();

    }

}
