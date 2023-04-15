package tests.selenide;

import org.junit.jupiter.api.Test;
import tests.page.TextBoxPage;

import static tests.data.values.ValuesTestBox.*;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {

        textBoxPage
                .openTextBox()
                .setFullName(fullNameValue)
                .setEmail(EmailValue)
                .setCurrentAddress(CurrentAddressValue)
                .setPermanentAddress(PermanentAddressValue)
                .clickButtonSubmit()
                .checkResults(
                        fullNameValue,
                        EmailValue,
                        CurrentAddressValue,
                        PermanentAddressValue);

    }
}
