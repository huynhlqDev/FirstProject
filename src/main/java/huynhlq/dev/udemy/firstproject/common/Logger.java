package huynhlq.dev.udemy.firstproject.common;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class Logger {

    public static void addActionLog(Object... message) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2]; // Lấy phương thức gọi log()
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        System.out.println(
                ">>> [" + LocalDateTime.now() + "] [" + "ACTION" + "] [" + className + "] [" + methodName + "] " +
                        Arrays.toString(message)
        );
    }
    public static void addErrorLog(Object... message) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[2]; // Lấy phương thức gọi log()
        String className = caller.getClassName();
        String methodName = caller.getMethodName();

        System.out.println(
                ">>> [" + LocalDateTime.now() + "] [" + "ERROR" + "] [" + className + "] [" + methodName + "] " +
                        Arrays.toString(message)
        );
    }
}
