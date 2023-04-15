package tests.data.values;

import static tests.utils.RandomUtils.*;

public class ValuePracticeForm {

    public static String
            FirstNameValue = getRandomFirstName(),
            LastNameValue = getRandomLastName(),
            EmailValue = getRandomEmail(),
            GenderValue = getRandomGender(),
            PhoneNumberValue = getRandomPhoneNumber(),
            BirthMonthValue = getRandomMonth(),
            BirthYearValue = getRandomYear(),
            BirthDayValue = getRandomDay(),
            SubjectsValue = getRandomSubjects(),
            HobbiesValue = getRandomHobbies(),
            CurrentAddressValue = getRandomAddress(),
            PictureValue = "wat.jpg",
            StateValue = getRandomState(),
            CityValue = getRandomCity(StateValue);

}
