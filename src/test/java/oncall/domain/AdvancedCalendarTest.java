package oncall.domain;

import oncall.constant.DayOfWeekKo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class AdvancedCalendarTest {
    @Test
    @DisplayName("내가 만든 달력 생성")
    void newWithConstructor() {
        assertThatCode(() -> {
            new AdvancedCalendar(12, DayOfWeekKo.SUNDAY);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("문자열을 통한 생성")
    @ValueSource(strings = {"12,일"})
    void from(String monthDayOfWeek) {
        assertThatCode(() -> {
            AdvancedCalendar.from(monthDayOfWeek);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("입력 인자가 충분치 않을 경우")
    @ValueSource(strings = {"12 월"})
    void validateEnough(String monthDayOfWeek) {
        assertThatCode(() -> AdvancedCalendar.from(monthDayOfWeek))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("월에 숫자가 아닌 것이 입력 되었을 경우")
    @ValueSource(strings = {"십이,일"})
    void validateMonthNumeric(String monthDayOfWeek) {
        assertThatCode(() -> AdvancedCalendar.from(monthDayOfWeek))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("월이 달력에 존재하지 않는 숫자일 경우")
    @ValueSource(strings = {"-1,일", "13,일"})
    void validateMonthInCalendar(String monthDayOfWeek) {
        assertThatCode(() -> AdvancedCalendar.from(monthDayOfWeek))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("요일이 달력에 존재하지 않을 경우")
    @ValueSource(strings = {"12, 왈", "12, 슈"})
    void validateDayOfWeekInCalendar(String monthDayOfWeek) {
        assertThatCode(() -> AdvancedCalendar.from(monthDayOfWeek))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
