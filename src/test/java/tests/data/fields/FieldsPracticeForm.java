package tests.data.fields;

public enum FieldsPracticeForm {

    FIELD_NAME("Name"),
    FIELD_EMAIL("Email"),
    FIELD_GENDER("Gender"),
    FIELD_MOBILE_WITH_DESCRIPTION("Mobile(10 Digits)"),
    FIELD_DATE_BIRTH("Date of Birth"),
    FIELD_SUBJECTS("Subjects"),
    FIELD_HOBBIES("Hobbies"),
    FIELD_PICTURE("Picture"),
    FIELD_CURRENT_ADDRESS("Current Address"),
    FIELD_STUDENT_NAME("Student Name"),
    FIELD_STUDENT_EMAIL("Student Email"),
    FIELD_MOBILE ("Mobile"),
    FIELD_ADDRESS ("Address"),
    COLUMN_NAME_LABEL("Label"),
    COLUMN_NAME_VALUES("Values"),
    FIELD_STATE_CITY("State and City"),
    PRACTICE_FORM_HEADER("Practice Form"),
    FORM_WRAPPER("Student Registration Form"),
    MODAL_SIZES_TITLE("Thanks for submitting the form");

    private String name;

    FieldsPracticeForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
