package oncall.constant;

public enum GeneralMessage {
    REQUEST_MONTH_DAY_OF_WEEK("비상 근무를 배정할 월과 시작 요일을 입력하세요>"),

    REQUEST_WEEKDAY_WORKER("평일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),

    REQUEST_DAY_OFF_WORKER("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>"),

    DAY_SCHEDULE("%d월 %d일 %s %s");

    private final String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
