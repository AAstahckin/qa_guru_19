package tests.data.viewmodel;

import static tests.data.values.ArraysValuesPracticeForm.*;
import static tests.utils.RandomUtils.*;

public class RegistrationFormViewModel {

    String[] randomDateBetween = getRandomDateBetween(17, 100);

    public String
            firstNameValue = getRandomFirstName(),
            lastNameValue = getRandomLastName(),
            emailValue = getRandomEmail(),
            genderValue = getRandomItemArray(GENDER_ARR.getValues()),
            phoneNumberValue = getRandomPhoneNumber(10),
            birthMonthValue = getMontFromDate(randomDateBetween),
            birthYearValue = getYearFromDate(randomDateBetween),
            birthDayValue = getDayFromDate(randomDateBetween),
            subjectsValue = getRandomItemArray(SUBJECTS_ARR.getValues()),
            hobbiesValue = getRandomItemArray(HOBBIES_ARR.getValues()),
            currentAddressValue = getRandomAddress(),
            pictureValue = getRandomFile(),
            stateValue = getRandomState(),
            cityValue = getRandomCity(stateValue);

}
