package tests.selenide;

import org.junit.jupiter.api.Test;
import tests.page.TextBoxPage;

import static tests.utils.RandomUtils.*;
import static tests.utils.RandomUtils.getRandomPermanentAddress;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    String
            fullNameValue = getRandomFullName(),
            emailValue = getRandomEmail(),
            currentAddressValue = getRandomAddress(),
            permanentAddressValue = getRandomPermanentAddress();

    @Test
    void successfulFillFormTest() {

        textBoxPage
                .openTextBox()
                .setFullName(fullNameValue)
                .setEmail(emailValue)
                .setCurrentAddress(currentAddressValue)
                .setPermanentAddress(permanentAddressValue)
                .clickButtonSubmit()
                .checkResults(
                        fullNameValue,
                        emailValue,
                        currentAddressValue,
                        permanentAddressValue);

    }
}
