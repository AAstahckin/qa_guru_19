package tests.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.viewmodel.RegistrationFormViewModel;
import tests.page.PracticeFormPage;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    RegistrationFormViewModel student = new RegistrationFormViewModel();

    @Tag("regression")
    @Test
    @DisplayName("Успешное заполнение формы automation-practice-form")
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

    @Tag("smoke")
    @Test
    @DisplayName("Проверка отображения полей и формы automation-practice-form")
    void checkFieldsPracticeForm() {
        practiceFormPage.openPracticeForm().checkFieldsNames();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка параметров automation-practice-form")
    void checkParams() {
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
                .clickSubmit();
    }

}
