package tests.data.viewmodel;

import static tests.utils.RandomUtils.*;
import static tests.utils.RandomUtils.getRandomPermanentAddress;

public class TextBoxViewModel {

    public String
            fullNameValue = getRandomFullName(),
            emailValue = getRandomEmail(),
            currentAddressValue = getRandomAddress(),
            permanentAddressValue = getRandomPermanentAddress();

}
