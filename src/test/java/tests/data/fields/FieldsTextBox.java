package tests.data.fields;

public enum FieldsTextBox {
    FIELD_NAME("Name"),
    FIELD_EMAIL("Email"),
    FIELD_FULL_NAME("Full Name"),
    FIELD_CURRENT_ADDRESS("Current Address"),
    FIELD_PERMANENT_ADDRESS("Permanent Address"),
    FIELD_PERMANANET_ADDRESS("Permananet Address"),
    TEXT_BOX_HEADER("Text Box");

    private String name;


    FieldsTextBox(String name) {
        this.name = name;
    }

    public String getFieldName() {
        return name;
    }

    }
