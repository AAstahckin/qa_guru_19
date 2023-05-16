package tests.selenide;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.data.viewmodel.TextBoxViewModel;
import tests.page.TextBoxPage;

@Tag("simple")
public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxViewModel textBoxValue = new TextBoxViewModel();

    @Test
    void successfulFillFormTest() {

        textBoxPage
                .openTextBox()
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
}
