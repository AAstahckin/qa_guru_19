package tests.testdata;

public interface ISelenideElements {

    String practiceFormHeader = ".main-header";
    String practiceForm = ".practice-form-wrapper";
    String fieldName = "#userName-label";
    String fieldEmail = "#userEmail-label";
    String fieldGenter = "#genterWrapper";
    String fieldUserNumber = "#userNumber-label";
    String fieldDateOfBirth = "#dateOfBirth-label";
    String fieldSubjects = "#subjectsWrapper";
    String fieldHobbies = "#hobbiesWrapper";
    String fieldPicture = "//label[@id='subjects-label'][starts-with(text(), 'Picture')]";
    String fieldAddress = "#currentAddress-label";
    String fieldStateCity = "#stateCity-label";

    String firstNameInput = "#firstName";
    String lastNameInput  = "#lastName";
    String userEmailInput  = "#userEmail";
    String dateOfBirthInput  = ".react-datepicker-wrapper .form-control";
    String userNumberInput  = "#userNumber";
    String uploadPicture  = "#uploadPicture";
    String subjectsInputInput  = "#subjectsInput";
    String currentAddressInput  = "#currentAddress";
    String userCityInput  = "#city";
    String submit  = "#submit";
    String closeSubmit  = "#closeLargeModal";
    String userStateInput   = "#state";
    String urlPracticeForm   = "/automation-practice-form";
    String monthSelect   = ".react-datepicker__month-select";
    String yearSelect   = ".react-datepicker__year-select";
    String daySelect   = ".react-datepicker__day--0%s";

    String tableResponsive   = ".table-responsive";
    String modalDialog   = ".modal-dialog";
    String exampleModalSizes   = "#example-modal-sizes-title-lg";

}
