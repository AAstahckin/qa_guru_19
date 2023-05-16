package tests.selenide;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.viewmodel.RegistrationFormViewModel;
import tests.page.PracticeFormPage;

@Tag("simple")
public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    RegistrationFormViewModel student = new RegistrationFormViewModel();

    @Test
    void randomValuesPracticeFormTest() {

        practiceFormPage
                .openPracticeForm()
                .checkFieldsNames()
                .setFirstName(student.firstNameValue)
                .setLastName(student.lastNameValue)
                .setUserEmail(student.emailValue)
                .setGender(student.genderValue)
                .setMobileNumber(student.phoneNumberValue)
                .setSubjects(student.subjectsValue)
                .setDateBirth(student.birthMonthValue, student.birthYearValue, student.birthDayValue)
                .setHobbies(student.hobbiesValue)
                .setAddress(student.currentAddressValue)
                .uploadFile(student.pictureValue)
                .setState(student.stateValue)
                .setCity(student.cityValue)
                .clickSubmit()
                .checkModalDialog()
                .verifyResults(student)
                .clickCloseSubmit();

    }

}
