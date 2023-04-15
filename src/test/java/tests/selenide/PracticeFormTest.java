package tests.selenide;

import org.junit.jupiter.api.Test;
import tests.page.PracticeFormPage;

import static tests.data.fields.IFieldsPracticeForm.*;
import static tests.data.values.ValuePracticeForm.*;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successfulFormTest() {

        practiceFormPage
                .openPracticeForm()
                .checkFieldsNames()
                .setFirstName(FirstNameValue)
                .setLastName(LastNameValue)
                .setUserEmail(EmailValue)
                .setGender(GenderValue)
                .setMobileNumber(PhoneNumberValue)
                .setSubjects(SubjectsValue)
                .setDateBirth(BirthMonthValue, BirthYearValue, BirthDayValue)
                .setHobbies(HobbiesValue)
                .setAddress(CurrentAddressValue)
                .uploadFile(PictureValue)
                .setState(StateValue)
                .setCity(CityValue)
                .clickSubmit()
                .checkModalDialog()
                    .verifyResults(FIELD_STUDENT_NAME, FirstNameValue + " " + LastNameValue)
                    .verifyResults(FIELD_STUDENT_EMAIL, EmailValue)
                    .verifyResults(FIELD_GENDER, GenderValue)
                    .verifyResults(FIELD_MOBILE, PhoneNumberValue)
                    .verifyResults(FIELD_DATE_BIRTH, BirthDayValue + " " + BirthMonthValue + "," + BirthYearValue)
                    .verifyResults(FIELD_SUBJECTS, SubjectsValue)
                    .verifyResults(FIELD_HOBBIES, HobbiesValue)
                    .verifyResults(FIELD_PICTURE, PictureValue)
                    .verifyResults(FIELD_ADDRESS, CurrentAddressValue)
                    .verifyResults(FIELD_STATE_CITY, StateValue + " " + CityValue)
                    .clickCloseSubmit();

    }

}
