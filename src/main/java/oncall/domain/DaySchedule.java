package oncall.domain;

import oncall.constant.DayOfWeekKo;

import java.util.List;

import static oncall.constant.GeneralMessage.DAY_SCHEDULE;

public record DaySchedule(int month, int day, DayOfWeekKo dayOfWeek, boolean dayOff, Worker worker) {
    private static final List<DayOfWeekKo> weekends = List.of(DayOfWeekKo.SUNDAY, DayOfWeekKo.SATURDAY);
    private static final String postfixDayOff = "(휴일)";

    private String buildDayOfWeekAsString() {
        if (!weekends.contains(dayOfWeek) && dayOff) {
            return dayOfWeek + postfixDayOff;
        }
        return dayOfWeek.toString();
    }

    @Override
    public String toString() {
        return String.format(DAY_SCHEDULE.toString(), month, day, buildDayOfWeekAsString(), worker.name());
    }
}
