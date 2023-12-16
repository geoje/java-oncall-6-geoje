package oncall.controller;

import oncall.view.OutputView;

import java.util.function.Supplier;

public class ScheduleController {
    public static void run() {

    }

    private static <T> T requestUntilValidated(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
