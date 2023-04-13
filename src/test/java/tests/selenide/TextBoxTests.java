package tests.selenide;

import org.junit.jupiter.api.Test;
import tests.page.TextBoxPage;

import static tests.data.IValuesPracticeForm.*;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillFormTest() {

        textBoxPage
                .openTextBox()
                .setUserName(valueFirstName)
                .setEmail(valueEmail)
                .setCurrentAddress(valueCurrentAddress)
                .setPermanentAddress(valuePermanentAddress)
                .clickButtonSubmit()
                .checkResults(
                        valueFirstName,
                        valueEmail,
                        valueCurrentAddress,
                        valuePermanentAddress);

    }
}
