package tests.selenide;

import org.junit.jupiter.api.Test;

import static tests.data.IFieldsPracticeForm.*;
import static tests.data.IValuesPracticeForm.*;

public class PracticeFormTest extends TestBase {

    @Test
    void successfulFormTest() {

        practiceFormPage
                .openPracticeForm()
                .checkFieldsNames()
                .setFirstName(valueFirstName)
                .setLastName(valueLastName)
                .setUserEmail(valueEmail)
                .setGender(valueGender)
                .setMobileNumber(valuePhoneNumber)
                .setSubjects(valueSubjects)
                .setDateBirth(valueBirthMonth, valueBirthYear, valueBirthDay)
                .setHobbies(valueHobbies)
                .setAddress(valueCurrentAddress)
                .uploadFile(valuePicture)
                .setState(valueState)
                .setCity(valueCity)
                .clickSubmit()
                .checkModalDialog()
                    .verifyResults(FIELD_STUDENT_NAME, valueFirstName + " " + valueLastName)
                    .verifyResults(FIELD_STUDENT_EMAIL, valueEmail)
                    .verifyResults(FIELD_GENDER, valueGender)
                    .verifyResults(FIELD_MOBILE, valuePhoneNumber)
                    .verifyResults(FIELD_DATE_BIRTH, valueBirthDay + " " + valueBirthMonth + "," + valueBirthYear)
                    .verifyResults(FIELD_SUBJECTS, valueSubjects)
                    .verifyResults(FIELD_HOBBIES, valueHobbies)
                    .verifyResults(FIELD_PICTURE, valuePicture)
                    .verifyResults(FIELD_ADDRESS, valueCurrentAddress)
                    .verifyResults(FIELD_STATE_CITY, valueState + " " + valueCity)
                    .clickCloseSubmit();

    }

}
