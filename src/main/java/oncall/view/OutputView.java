package oncall.view;

import oncall.constant.GeneralMessage;

import static oncall.constant.ErrorMessage.EXCEPTION_PREFIX;

public class OutputView {

    private static void printGeneralMessage(GeneralMessage message, Object... args) {
        System.out.printf(message + "%n", args);
    }

    public static void printErrorMessage(String message) {
        System.out.println(EXCEPTION_PREFIX + message);
    }

    public static void printTwoNewLines() {
        System.out.printf("%n%n");
    }

    public static void printResult(Object result) {
        System.out.println(result);
    }
}
