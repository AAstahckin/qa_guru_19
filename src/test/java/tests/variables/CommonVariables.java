package tests.variables;

public enum CommonVariables {

    TEST_FILES("src/test/resources/testfiles/");

    public String name;


    CommonVariables(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
