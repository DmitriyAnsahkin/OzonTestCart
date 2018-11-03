package helpers;

import io.qameta.allure.Allure;

public class ReportHelper {
    public static void addTextAttach(String text) {
        Allure.addAttachment(text, "text/plain");
    }

    public static void addTestDescription(String text) {
        Allure.addDescription(text);
    }

    /**
     * можно в дескрипшн прокинуть html который буде трендерится, можно придумать что-то интересное и полезное
     *
     * @param text
     */
    public static void addHtmlDescription(String text) {
        Allure.addDescriptionHtml(text);
    }

}
