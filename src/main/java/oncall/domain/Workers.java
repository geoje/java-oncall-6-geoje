package oncall.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static oncall.constant.ErrorMessage.INVALID_VALUE;

public class Workers {
    private static final String DELIMITER = ",";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 35;

    private final List<Worker> workers;
    private int index = 0;
    private boolean change = false;

    public Workers(List<Worker> workers) {
        this.workers = workers;
        validateDuplicate(workers);
        validateLength(workers);
    }

    public static Workers from(String workers) {
        return new Workers(Arrays.stream(workers.split(DELIMITER)).map(Worker::new).toList());
    }

    private int nextIndex() {
        return (index + 1) % workers.size();
    }

    private int prevIndex() {
        if (index == 0) return workers.size() - 1;
        return index - 1;
    }

    private Worker nextWithChange() {
        if (change) {
            return workers.get(prevIndex());
        }
        return workers.get(index);
    }

    public Worker next(String avoidWorkerName) {
        Worker worker = nextWithChange();
        change = false;

        if (worker.name().equals(avoidWorkerName)) {
            change = true;
            index = nextIndex();
            return workers.get(index);
        }

        index = nextIndex();
        return worker;
    }

    private void validateDuplicate(List<Worker> workers) {
        if (workers.size() != workers.stream().map(Worker::name).collect(Collectors.toSet()).size()) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }

    private void validateLength(List<Worker> workers) {
        if (workers.size() < MIN_LENGTH || workers.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_VALUE.toString());
        }
    }
}
