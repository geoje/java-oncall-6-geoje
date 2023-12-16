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

    public static void printResult() {
        System.out.printf("%n%n여기에 결과가!%n");
    }
}
