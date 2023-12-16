package oncall.constant;

import java.util.Arrays;
import java.util.Calendar;

public enum Holiday {
    NEW_YEAR(Calendar.JANUARY, 1, "신정"),
    INDEPENDENCE_MOVEMENT_DAY(Calendar.MARCH, 1, "삼일절"),
    CHILDREN_S_DAY(Calendar.MAY, 5, "어린이날"),
    MEMORIAL_DAY(Calendar.JUNE, 6, "현충일"),
    NATIONAL_LIBERATION_DAY(Calendar.AUGUST, 15, "광복절"),
    NATIONAL_FOUNDATION_DAY_OF_KOREA(Calendar.OCTOBER, 3, "개천절"),
    HANGUL_PROCLAMATION_DAY(Calendar.OCTOBER, 9, "한글날"),
    CHRISTMAS_DAY(Calendar.DECEMBER, 25, "성탄절");

    private final int month;
    private final int day;
    private final String name;

    /**
     * @param month Calendar.JANUARY, ...
     * @param day
     * @param name
     */
    Holiday(int month, int day, String name) {
        this.month = month;
        this.day = day;
        this.name = name;
    }

    public static boolean is(int month, int day) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.month == month && holiday.day == day);
    }
}
