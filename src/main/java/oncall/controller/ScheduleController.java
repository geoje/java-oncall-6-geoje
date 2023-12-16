package oncall.controller;

import oncall.domain.AdvancedCalendar;
import oncall.domain.Workers;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.function.Supplier;

public class ScheduleController {
    public static void run() {
        AdvancedCalendar advancedCalendar = requestAdvancedCalendar();
        Workers weekdayWorkers = requestWeekdayWorkers();
        Workers dayoffWorkers = requestDayoffWorkers();
        printResult();
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

    private static AdvancedCalendar requestAdvancedCalendar() {
        return requestUntilValidated(() -> AdvancedCalendar.from(InputView.readMonthDayOfWeek()));
    }

    private static Workers requestWeekdayWorkers() {
        return requestUntilValidated(() -> Workers.from(InputView.readWeekdayWorkers()));
    }

    private static Workers requestDayoffWorkers() {
        return requestUntilValidated(() -> Workers.from(InputView.readDayOffWorkers()));
    }

    private static void printResult() {
        OutputView.printResult();
    }
}
