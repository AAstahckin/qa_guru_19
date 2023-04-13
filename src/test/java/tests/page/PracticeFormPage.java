package tests.page;

import com.codeborne.selenide.SelenideElement;
import tests.page.components.CalendarComponent;
import tests.page.components.ResultsModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.data.IDemoqaUrls.AUTOMATION_PRACTICE_FORM;
import static tests.data.IFieldsPracticeForm.*;
import static tests.selenide.JavaScriptActions.removeBanners;

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

    public PracticeFormPage openPracticeForm() {
        open(AUTOMATION_PRACTICE_FORM);
        removeBanners();
        practiceFormHeader.shouldHave(text(PRACTICE_FORM_HEADER));
        practiceForm.shouldHave(text(FORM_WRAPPER));
        return this;
    }

    public PracticeFormPage checkFieldsNames() {
        fieldName.shouldHave(text(FIELD_NAME));
        fieldEmail.shouldHave(text(FIELD_EMAIL));
        fieldGender.shouldHave(text(FIELD_GENDER));
        fieldUserNumber.shouldHave(text(FIELD_MOBILE_WITH_DESCRIPTION));
        fieldDateOfBirth.shouldHave(text(FIELD_DATE_BIRTH));
        fieldSubjects.shouldHave(text(FIELD_SUBJECTS));
        fieldHobbies.shouldHave(text(FIELD_HOBBIES));
        fieldPicture.shouldHave(text(FIELD_PICTURE));
        fieldAddress.shouldHave(text(FIELD_CURRENT_ADDRESS));
        fieldStateCity.shouldHave(text(FIELD_STATE_CITY));
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }


    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        fieldGender.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setMobileNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();
        return this;
    }

    public PracticeFormPage setDateBirth(String month, String year, String day) {
        dateBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        fieldHobbies.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        currentAddressInput.setValue(value).click();
        return this;
    }

    public PracticeFormPage uploadFile(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        userStateInput.click();
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        userCityInput.click();
        $(byText(value)).click();
        return this;
    }

    public PracticeFormPage clickSubmit() {
        submit.click();
        return this;
    }

    public PracticeFormPage verifyResults(String key, String value) {
        resultsModalComponent.checkResults(key, value);
        return this;
    }

    public PracticeFormPage clickCloseSubmit() {
        closeSubmit.shouldHave(visible).click();
        return this;
    }

    public PracticeFormPage checkModalDialog() {
        modalDialog.shouldHave(visible);
        exampleModalSizes.shouldHave(text(MODAL_SIZES_TITLE));
        tableResponsive.shouldHave(text(COLUMN_NAME_LABEL));
        tableResponsive.shouldHave(text(COLUMN_NAME_VALUES));
        return this;
    }

}
