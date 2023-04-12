package tests.selenide;

import org.junit.jupiter.api.Test;
import static tests.data.IValuesPracticeForm.*;

public class TextBoxTests extends TestBase {

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
