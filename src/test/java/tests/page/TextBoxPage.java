package tests.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открываем страницу text-box")
    public TextBoxPage openTextBox() {
        open(TEXT_BOX.getUrl());
        removeBanners();
        return this;
    }

    @Step("Проверяем присутствие полей на странице")
    public TextBoxPage checkFieldsTestBox(){
        mainHeader.shouldHave(text(TEXT_BOX_HEADER.getFieldName()));
        labelUserName.shouldHave(text(FIELD_FULL_NAME.getFieldName()));
        labelEmail.shouldHave(text(FIELD_EMAIL.getFieldName()));
        labelCurrentAddress.shouldHave(text(FIELD_CURRENT_ADDRESS.getFieldName()));
        labelPermanentAddress.shouldHave(text(FIELD_PERMANENT_ADDRESS.getFieldName()));
        return this;
    }

    @Step("Вводим значение {value} в поле FullName")
    public TextBoxPage setFullName(String value) {
        userNameInput.setValue(value);
        return this;
    }

    @Step("Вводим значение {value} в поле Email")
    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Вводим значение {value} в поле CurrentAddress")
    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Вводим значение {value} в поле PermanentAddress")
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку Submit")
    public TextBoxPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    @Step("Проверяем сохранение параметров")
    public TextBoxPage checkResults(String valueName, String email, String currentAddress, String permanentAddress) {
        textBoxComponent.outputResult(valueName, email, currentAddress, permanentAddress);
        return this;
    }

}
