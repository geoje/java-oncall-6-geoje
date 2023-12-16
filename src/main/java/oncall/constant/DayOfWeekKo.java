package oncall.constant;

import java.util.Arrays;
import java.util.Calendar;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public enum DayOfWeekKo {
    SUNDAY(Calendar.SUNDAY, "일"),
    MONDAY(Calendar.MONDAY, "월"),
    TUESDAY(Calendar.TUESDAY, "화"),
    WEDNESDAY(Calendar.WEDNESDAY, "수"),
    THURSDAY(Calendar.THURSDAY, "목"),
    FRIDAY(Calendar.FRIDAY, "금"),
    SATURDAY(Calendar.SATURDAY, "토");

    private final int dayOfWeek;
    private final String name;

    DayOfWeekKo(int dayOfWeek, String name) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
    }

    public static DayOfWeekKo from(String name) {
        return Arrays.stream(values())
                .filter(v -> v.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE.toString()));
    }

    public static DayOfWeekKo from(int dayOfWeek) {
        int min = Arrays.stream(values()).mapToInt(value -> value.dayOfWeek).min().getAsInt();
        int max = Arrays.stream(values()).mapToInt(value -> value.dayOfWeek).max().getAsInt();

        while (dayOfWeek < min) {
            dayOfWeek += values().length;
        }
        while (dayOfWeek > max) {
            dayOfWeek -= values().length;
        }

        int finalDayOfWeek = dayOfWeek;
        return Arrays.stream(values()).filter(v -> v.dayOfWeek == finalDayOfWeek)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE.toString()));
    }

    public int getValue() {
        return dayOfWeek;
    }

    @Override
    public String toString() {
        return name;
    }
}
