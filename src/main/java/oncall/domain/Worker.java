package oncall.domain;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public record Worker(String name) {
    private static final int MAX_LENGTH = 5;

    public Worker {
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (name.isBlank() || name.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }
}