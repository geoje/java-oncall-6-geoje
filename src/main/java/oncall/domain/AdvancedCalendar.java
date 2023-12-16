package oncall.domain;

import oncall.constant.DayOfWeekKo;

import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public record AdvancedCalendar(int month, DayOfWeekKo dayOfWeek) {
    private static final String DELIMITER = ",";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private static final Calendar CAL = Calendar.getInstance();
    private static final int YEAR = 2023;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    public AdvancedCalendar {
        CAL.set(Calendar.YEAR, YEAR);
    }

    public static AdvancedCalendar from(String monthDayOfWeek) {
        validateCount(monthDayOfWeek);
        String month = monthDayOfWeek.split(DELIMITER)[0];
        String dayOfWeek = monthDayOfWeek.split(DELIMITER)[1];
        validateNumeric(month);
        validateMonth(month);

        return new AdvancedCalendar(Integer.parseInt(month), DayOfWeekKo.from(dayOfWeek));
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
        return List.of(
                new DaySchedule(12, 1, DayOfWeekKo.SUNDAY, false, new Worker("경호")),
                new DaySchedule(12, 2, DayOfWeekKo.MONDAY, false, new Worker("수빈")),
                new DaySchedule(12, 3, DayOfWeekKo.TUESDAY, true, new Worker("진서"))
        );
    }
}
