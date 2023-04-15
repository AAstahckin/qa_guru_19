package tests.data.values;

import static tests.utils.RandomUtils.*;
import static tests.utils.RandomUtils.getRandomPermanentAddress;

public class ValuesTestBox {

    public static String
            fullNameValue = getRandomFullName(),
            EmailValue = getRandomEmail(),
            CurrentAddressValue = getRandomAddress(),
            PermanentAddressValue = getRandomPermanentAddress();

}
