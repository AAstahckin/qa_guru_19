package tests.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    SelenideElement
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    String daySelect = ".react-datepicker__day--%s";

    public void setDate(String month, String year, String day) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        if (day.length() == 2) {
            $(String.format(daySelect, "0" + day)).click();
        } else {
            $(String.format(daySelect, "00" + day)).click();
        }
    }

}
