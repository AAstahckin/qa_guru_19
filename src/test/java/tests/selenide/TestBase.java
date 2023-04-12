package tests.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import tests.pageobjects.PracticeFormPage;
import tests.pageobjects.TextBoxPage;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }
}
