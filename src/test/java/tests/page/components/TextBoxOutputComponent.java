package tests.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static tests.data.fields.FieldsTextBox.*;

public class TextBoxOutputComponent {

    SelenideElement
            outputName = $("#name"),
            outputEmail = $("#email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public void outputResult(String valueName, String email, String currentAddress, String permanentAddress) {
        outputName.shouldHave(text(FIELD_NAME.getFieldName() + ":" + valueName));
        outputEmail.shouldHave(text(FIELD_EMAIL.getFieldName() + ":"  + email));
        outputCurrentAddress.shouldHave(text(FIELD_CURRENT_ADDRESS.getFieldName() + " :"  + currentAddress));
        outputPermanentAddress.shouldHave(text(FIELD_PERMANANET_ADDRESS.getFieldName() + " :"  + permanentAddress));
    }

}
