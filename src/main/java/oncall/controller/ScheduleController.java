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
        List<Workers> twoWorkers = requestWeekdayAndDayOffWorkers();
        printResult(advancedCalendar, twoWorkers.get(0), twoWorkers.get(1));
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

    private static List<Workers> requestWeekdayAndDayOffWorkers() {
        return requestUntilValidated(() -> List.of(
                Workers.from(InputView.readWeekdayWorkers()),
                Workers.from(InputView.readDayOffWorkers())
        ));
    }

    private static void printResult(
            AdvancedCalendar advancedCalendar,
            Workers weekdayWorkers,
            Workers dayoffWorkers) {
        OutputView.printTwoNewLines();
        advancedCalendar.buildTable(weekdayWorkers, dayoffWorkers)
                .forEach(OutputView::printResult);
    }
}
