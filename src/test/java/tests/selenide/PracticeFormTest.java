package tests.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.ISelenideElements.*;
import static tests.testdata.IValuesPracticeForm.*;

public class PracticeFormTest extends TestBase {

    @Test
    void successfulFormTest() {
        open(urlPracticeForm);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(practiceFormHeader).shouldHave(text("Practice Form"));

        $(practiceForm).shouldHave(text("Student Registration Form"));
        $(fieldName).shouldHave(text("Name"));
        $(fieldEmail).shouldHave(text("Email"));
        $(fieldGenter).shouldHave(text("Gender"));
        $(fieldUserNumber).shouldHave(text("Mobile(10 Digits)"));
        $(fieldDateOfBirth).shouldHave(text("Date of Birth"));
        $(fieldSubjects).shouldHave(text("Subjects"));
        $(fieldHobbies).shouldHave(text("Hobbies"));
        $x(fieldPicture).shouldHave(text("Picture"));
        $(fieldAddress).shouldHave(text("Current Address"));
        $(fieldStateCity).shouldHave(text("State and City"));

        $(firstNameInput).setValue(valueFirstName);
        $(lastNameInput).setValue(valueLastName);
        $(userEmailInput).setValue(valueEmail);
        $(fieldGenter).$(byText(valueGender)).click();
        $(userNumberInput).setValue(valuePhoneNumber);
        $(subjectsInputInput).sendKeys(valueSubjects);
        $(subjectsInputInput).pressEnter();
        $(dateOfBirthInput).click();
        $(monthSelect).selectOption(valueBirthMonth);
        $(yearSelect).selectOption(valueBirthYear);
        $(String.format(daySelect, valueBirthDay)).click();
        $(fieldHobbies).$(byText(valueHobbies)).click();
        $(currentAddressInput).setValue(valueAddress);
        $(uploadPicture).uploadFromClasspath(valuePicture);
        $(userStateInput).click();
        $(byText(valueState)).click();
        $(userCityInput).click();
        $(byText(valueCity)).click();
        $(submit).click();

        $(modalDialog).shouldHave(visible);
        $(exampleModalSizes).shouldHave(text("Thanks for submitting the form"));
        $(tableResponsive).shouldHave(text("Label"));
        $(tableResponsive).shouldHave(text("Values"));

        $(tableResponsive).shouldHave(
                text(valueFirstName),
                text(valueLastName),
                text(valueEmail),
                text(valueGender),
                text(valuePhoneNumber),
                text(valueBirthDay + " " + valueBirthMonth + "," + valueBirthYear),
                text(valueSubjects),
                text(valueHobbies),
                text(valuePicture),
                text(valueAddress),
                text(valueState + " " + valueCity));

        $(closeSubmit).shouldHave(visible);
        $(closeSubmit).click();
    }
}
