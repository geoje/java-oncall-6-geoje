package oncall.domain;

import oncall.constant.DayOfWeekKo;
import oncall.constant.Holiday;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public record AdvancedCalendar(int month, DayOfWeekKo dayOfWeek) {
    private static final String DELIMITER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Calendar CAL = Calendar.getInstance();
    private static final int YEAR = 2023;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    public AdvancedCalendar {
        CAL.set(YEAR, month, 1);
    }

    public static AdvancedCalendar from(String monthDayOfWeek) {
        validateCount(monthDayOfWeek);
        String month = monthDayOfWeek.split(DELIMITER)[0];
        String dayOfWeek = monthDayOfWeek.split(DELIMITER)[1];
        validateNumeric(month);
        validateMonth(month);

        return new AdvancedCalendar(Integer.parseInt(month) - 1, DayOfWeekKo.from(dayOfWeek));
    }

    private static void validateNumeric(String month) {
        if (!NUMBER_PATTERN.matcher(month).matches()) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }

    private static void validateMonth(String month) {
        int parsedMonth = Integer.parseInt(month);
        if (parsedMonth < MIN_MONTH || parsedMonth > MAX_MONTH) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }

    private static void validateCount(String monthDayOfWeek) {
        if (monthDayOfWeek.split(DELIMITER).length < 2) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }

    public List<DaySchedule> buildTable(Workers weekdayWorkers, Workers dayoffWorkers) {
        int offset = dayOfWeek.getValue() - CAL.get(Calendar.DAY_OF_WEEK);

        return IntStream
                .range(1, CAL.getMaximum(Calendar.DAY_OF_MONTH))
                .mapToObj(day -> new DaySchedule(
                        month,
                        day,
                        DayOfWeekKo.from(day + offset),
                        Holiday.is(month, day),
                        weekdayWorkers.workers().get(0)))
                .toList();
    }
}
