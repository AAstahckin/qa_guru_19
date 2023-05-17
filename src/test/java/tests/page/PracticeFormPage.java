package tests.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.data.viewmodel.RegistrationFormViewModel;
import tests.page.components.CalendarComponent;
import tests.page.components.ResultsModalComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.data.fields.FieldsPracticeForm.*;
import static tests.page.components.JavaScriptActions.removeBanners;
import static tests.variables.CommonVariables.TEST_FILES;
import static tests.variables.DemoqaUrls.AUTOMATION_PRACTICE_FORM;

public class PracticeFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModalComponent = new ResultsModalComponent();

    SelenideElement
            practiceFormHeader = $(".main-header"),
            practiceForm = $(".practice-form-wrapper"),
            fieldName = $("#userName-label"),
            fieldEmail = $("#userEmail-label"),
            fieldGender = $("#genterWrapper"),
            fieldUserNumber = $("#userNumber-label"),
            fieldDateOfBirth = $("#dateOfBirth-label"),
            fieldSubjects = $("#subjectsWrapper"),
            fieldHobbies = $("#hobbiesWrapper"),
            fieldPicture = $x("//label[@id='subjects-label'][starts-with(text(), 'Picture')]"),
            fieldAddress = $("#currentAddress-label"),
            fieldStateCity = $("#stateCity-label"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            uploadPicture = $("#uploadPicture"),
            subjectsInput = $("#subjectsInput"),
            currentAddressInput = $("#currentAddress"),
            userCityInput = $("#city"),
            submit = $("#submit"),
            closeSubmit = $("#closeLargeModal"),
            userStateInput = $("#state"),
            dateBirthInput = $(".react-datepicker-wrapper .form-control"),
            tableResponsive = $(".table-responsive"),
            modalDialog = $(".modal-dialog"),
            exampleModalSizes = $("#example-modal-sizes-title-lg");

    @Step("Открываем страницу automation-practice-form")
    public PracticeFormPage openPracticeForm() {
        open(AUTOMATION_PRACTICE_FORM.getUrl());
        removeBanners();
        practiceFormHeader.shouldHave(text(PRACTICE_FORM_HEADER.getName()));
        practiceForm.shouldHave(text(FORM_WRAPPER.getName()));
        return this;
    }

    @Step("Проверяем что все поля на форме присутствуют")
    public PracticeFormPage checkFieldsNames() {
        fieldName.shouldHave(text(FIELD_NAME.getName()));
        fieldEmail.shouldHave(text(FIELD_EMAIL.getName()));
        fieldGender.shouldHave(text(FIELD_GENDER.getName()));
        fieldUserNumber.shouldHave(text(FIELD_MOBILE_WITH_DESCRIPTION.getName()));
        fieldDateOfBirth.shouldHave(text(FIELD_DATE_BIRTH.getName()));
        fieldSubjects.shouldHave(text(FIELD_SUBJECTS.getName()));
        fieldHobbies.shouldHave(text(FIELD_HOBBIES.getName()));
        fieldPicture.shouldHave(text(FIELD_PICTURE.getName()));
        fieldAddress.shouldHave(text(FIELD_CURRENT_ADDRESS.getName()));
        fieldStateCity.shouldHave(text(FIELD_STATE_CITY.getName()));
        return this;
    }

    @Step("Вводим в поле FirstName значение: {value}")
    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим в поле LastName значение: {value}")
    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }


    @Step("Вводим в поле UserEmail значение: {value}")
    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("В разделе Gender выбираем : {value}")
    public PracticeFormPage setGender(String value) {
        fieldGender.$(byText(value)).click();
        return this;
    }

    @Step("Вводим в поле Mobile значение: {value}")
    public PracticeFormPage setMobileNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Вводим в поле Subjects значение: {value}")
    public PracticeFormPage setSubjects(String value) {
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();
        return this;
    }

    @Step("В поле Date of Birth выбираем дату : {month}:{year}:{day}")
    public PracticeFormPage setDateBirth(String month, String year, String day) {
        dateBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    @Step("В разделе Hobbies выбираем: {value}")
    public PracticeFormPage setHobbies(String value) {
        fieldHobbies.$(byText(value)).click();
        return this;
    }

    @Step("В поле Current Address вводим адрес: {value}")
    public PracticeFormPage setAddress(String value) {
        currentAddressInput.setValue(value).click();
        return this;
    }

    @Step("Загружаем файл на страницу: {value}")
    public PracticeFormPage uploadFile(String value) {
        uploadPicture.uploadFile(new File(TEST_FILES.getName() + value));
        return this;
    }

    @Step("Выбираем из списка в поле State значение: {value}")
    public PracticeFormPage setState(String value) {
        userStateInput.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Выбираем из списка в поле City значение: {value}")
    public PracticeFormPage setCity(String value) {
        userCityInput.click();
        $(byText(value)).click();
        return this;
    }

    @Step("Нажимаем на кнопку Submit")
    public PracticeFormPage clickSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверяем что все параметры заполнены верно")
    public PracticeFormPage verifyResults(RegistrationFormViewModel value) {
        resultsModalComponent
                .checkResults(FIELD_STUDENT_NAME.getName(), value.firstNameValue + " " + value.lastNameValue)
                .checkResults(FIELD_STUDENT_EMAIL.getName(), value.emailValue)
                .checkResults(FIELD_GENDER.getName(), value.genderValue)
                .checkResults(FIELD_MOBILE.getName(), value.phoneNumberValue)
                .checkResults(FIELD_DATE_BIRTH.getName(), value.birthDayValue + " " + value.birthMonthValue + "," + value.birthYearValue)
                .checkResults(FIELD_SUBJECTS.getName(), value.subjectsValue)
                .checkResults(FIELD_PICTURE.getName(), value.pictureValue)
                .checkResults(FIELD_ADDRESS.getName(), value.currentAddressValue)
                .checkResults(FIELD_STATE_CITY.getName(), value.stateValue + " " + value.cityValue);
        return this;
    }

    @Step("Нажимаем на кнопку Close")
    public PracticeFormPage clickCloseSubmit() {
        closeSubmit.shouldHave(visible).click();
        return this;
    }

    @Step("Проверяем отображение модального окна")
    public PracticeFormPage checkModalDialog() {
        modalDialog.shouldHave(visible);
        exampleModalSizes.shouldHave(text(MODAL_SIZES_TITLE.getName()));
        tableResponsive.shouldHave(text(COLUMN_NAME_LABEL.getName()));
        tableResponsive.shouldHave(text(COLUMN_NAME_VALUES.getName()));
        return this;
    }

}
