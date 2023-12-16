package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.constant.GeneralMessage;

public class InputView {
    private static String readWithGeneralMessage(GeneralMessage message, Object... args) {
        System.out.printf(message.toString() + " ", args);
        return Console.readLine().trim();
    }

    public static String readMonthDayOfWeek() {
        return readWithGeneralMessage(GeneralMessage.REQUEST_MONTH_DAY_OF_WEEK);
    }

    public static String readWeekdayWorkers() {
        return readWithGeneralMessage(GeneralMessage.REQUEST_WEEKDAY_WORKER);
    }

    public static String readDayOffWorkers() {
        return readWithGeneralMessage(GeneralMessage.REQUEST_DAY_OFF_WORKER);
    }
}
