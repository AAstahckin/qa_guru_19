package tests.page.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModalComponent {

    SelenideElement tableResponsive = $(".table-responsive");

    public ResultsModalComponent checkResults(String key, String value) {
        Allure.step("Проверяем что поле " + key + " заполнено значением : " + value);
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
