package tests.variables;

public enum DemoqaUrls {

    TEXT_BOX("/text-box"),
    AUTOMATION_PRACTICE_FORM("/automation-practice-form");

    public String name;


    DemoqaUrls(String name) {
        this.name = name;
    }

    public String getUrl() {
        return name;
    }

}
