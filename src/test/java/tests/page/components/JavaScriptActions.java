package tests.page.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavaScriptActions {

    public static void removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

}
