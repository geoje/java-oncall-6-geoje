package oncall.domain;

import java.util.Arrays;
import java.util.List;

public record Workers(List<Worker> workers) {
    private static final String DELIMITER = ",";

    public static Workers from(String workers) {
        return new Workers(Arrays.stream(workers.split(DELIMITER)).map(Worker::new).toList());
    }
}
