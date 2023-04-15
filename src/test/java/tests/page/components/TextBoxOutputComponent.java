package tests.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static tests.data.fields.IFieldsPracticeForm.*;

public class TextBoxOutputComponent {

    SelenideElement
            outputName = $("#name"),
            outputEmail = $("#email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public void outputResult(String valueName, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(FIELD_NAME + ":" + valueName));
        outputEmail.shouldHave(text(FIELD_EMAIL + ":"  + email));
        outputCurrentAddress.shouldHave(text(FIELD_CURRENT_ADDRESS + " :"  + currentAddress));
        outputPermanentAddress.shouldHave(text(FIELD_PERMANANET_ADDRESS + " :"  + permanentAddress));
    }

}
