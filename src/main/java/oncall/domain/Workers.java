package oncall.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public record Workers(List<Worker> workers) {
    private static final String DELIMITER = ",";
    private static final int MAX_LENGTH = 35;

    public Workers {
        validateDuplicate(workers);
        validateLength(workers);
    }

    public static Workers from(String workers) {
        return new Workers(Arrays.stream(workers.split(DELIMITER)).map(Worker::new).toList());
    }

    private void validateDuplicate(List<Worker> workers) {
        if (workers.size() != workers.stream().map(Worker::name).collect(Collectors.toSet()).size()) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }

    private void validateLength(List<Worker> workers) {
        if (workers.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }
}
