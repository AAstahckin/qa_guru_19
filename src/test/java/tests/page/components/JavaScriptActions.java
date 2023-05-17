package tests.page.components;

import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavaScriptActions {

    public static void removeBanners() {
        Allure.step("Убираем банеры");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

}
