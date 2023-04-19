package tests.page;

import com.codeborne.selenide.SelenideElement;
import tests.page.components.TextBoxOutputComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static tests.data.fields.FieldsTextBox.*;
import static tests.page.components.JavaScriptActions.removeBanners;
import static tests.variables.DemoqaUrls.TEXT_BOX;

public class TextBoxPage {

    TextBoxOutputComponent textBoxComponent = new TextBoxOutputComponent();

    SelenideElement
            mainHeader = $(".main-header"),
            userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            buttonSubmit = $("#submit"),
            labelUserName = $("#userName-label"),
            labelEmail = $("#userEmail-label"),
            labelCurrentAddress = $("#currentAddress-label"),
            labelPermanentAddress = $("#permanentAddress-label");

    public TextBoxPage openTextBox() {
        open(TEXT_BOX.getUrl());
        removeBanners();
        mainHeader.shouldHave(text(TEXT_BOX_HEADER.getFieldName()));
        labelUserName.shouldHave(text(FIELD_FULL_NAME.getFieldName()));
        labelEmail.shouldHave(text(FIELD_EMAIL.getFieldName()));
        labelCurrentAddress.shouldHave(text(FIELD_CURRENT_ADDRESS.getFieldName()));
        labelPermanentAddress.shouldHave(text(FIELD_PERMANENT_ADDRESS.getFieldName()));
        return this;
    }

    public TextBoxPage setFullName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public TextBoxPage checkResults(String valueName, String email, String currentAddress, String permanentAddress) {
        textBoxComponent.outputResult(valueName, email, currentAddress, permanentAddress);
        return this;
    }

}
