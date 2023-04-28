package tests.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static tests.variables.DemoqaUrls.BAE_URL;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = BAE_URL.getUrl();
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }
}
