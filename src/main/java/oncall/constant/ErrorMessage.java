package oncall.constant;

public enum ErrorMessage {
    EXCEPTION_PREFIX("[ERROR] "),
    INVALID_VALUE("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
