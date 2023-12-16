package oncall.constant;

import java.time.DayOfWeek;
import java.util.Arrays;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public enum DayOfWeekKo {
    SUNDAY(DayOfWeek.SUNDAY, "일"),
    MONDAY(DayOfWeek.MONDAY, "월"),
    TUESDAY(DayOfWeek.TUESDAY, "화"),
    WEDNESDAY(DayOfWeek.WEDNESDAY, "수"),
    THURSDAY(DayOfWeek.THURSDAY, "목"),
    FRIDAY(DayOfWeek.FRIDAY, "금"),
    SATURDAY(DayOfWeek.SATURDAY, "토");

    private final DayOfWeek dayOfWeek;
    private final String name;

    DayOfWeekKo(DayOfWeek dayOfWeek, String name) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
    }

    public static DayOfWeekKo from(String name) {
        return Arrays.stream(values())
                .filter(v -> v.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_VALUE.toString()));
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String toString() {
        return name;
    }
}
