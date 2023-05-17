package tests.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.viewmodel.TextBoxViewModel;
import tests.page.TextBoxPage;


public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxViewModel textBoxValue = new TextBoxViewModel();

    @Tag("regression")
    @Test
    @DisplayName("Успешное заполнение формы text-Box")
    void successfulFillFormTest() {

        textBoxPage
                .openTextBox()
                .checkFieldsTestBox()
                .setFullName(textBoxValue.fullNameValue)
                .setEmail(textBoxValue.emailValue)
                .setCurrentAddress(textBoxValue.currentAddressValue)
                .setPermanentAddress(textBoxValue.permanentAddressValue)
                .clickButtonSubmit()
                .checkResults(
                        textBoxValue.fullNameValue,
                        textBoxValue.emailValue,
                        textBoxValue.currentAddressValue,
                        textBoxValue.permanentAddressValue);

    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка параметров text-Box")
    void checkSetValueFromFields() {
        textBoxPage
                .openTextBox()
                .checkFieldsTestBox()
                .setFullName(textBoxValue.fullNameValue)
                .setEmail(textBoxValue.emailValue)
                .setCurrentAddress(textBoxValue.currentAddressValue)
                .setPermanentAddress(textBoxValue.permanentAddressValue);
    }

    @Tag("smoke")
    @Test
    @DisplayName("Проверка отображения полей и формы text-Box")
    void checkFieldsTestBox() {
        textBoxPage.openTextBox().checkFieldsTestBox();
    }


}
