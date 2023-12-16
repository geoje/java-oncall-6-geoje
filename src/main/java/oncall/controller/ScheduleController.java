package oncall.controller;

import oncall.domain.AdvancedCalendar;
import oncall.domain.Workers;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class ScheduleController {
    public static void run() {
        AdvancedCalendar advancedCalendar = requestAdvancedCalendar();
        List<Workers> TwoWorkers = requestWeekdayAndDayoffWorkers();
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

    private static List<Workers> requestWeekdayAndDayoffWorkers() {
        return requestUntilValidated(() -> List.of(
                Workers.from(InputView.readWeekdayWorkers()),
                Workers.from(InputView.readDayOffWorkers())
        ));
    }

    private static void printResult() {
        OutputView.printResult();
    }
}
