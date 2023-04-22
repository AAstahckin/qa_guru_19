package tests.data.values;

public enum ArraysValuesPracticeForm {

    SUBJECTS_ARR(new String[]{
            "Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
            "Computer Science", "Commerce", "Accounting", "Economics", "Arts",
            "Social Studies", "History", "Civics" }),
    GENDER_ARR(new String[]{"Male", "Female", "Other"}),
    HOBBIES_ARR(new String[]{"Sports", "Reading", "Music"});

    private String[] value;

    ArraysValuesPracticeForm(String[] value) {
        this.value = value;
    }

    public String[] getValues() {
        return value;
    }

}
