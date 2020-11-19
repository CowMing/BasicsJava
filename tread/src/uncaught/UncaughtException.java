package uncaught;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UncaughtException implements Thread.UncaughtExceptionHandler {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger log = Logger.getAnonymousLogger();
        log.log(Level.WARNING, "线程中止拉" + t.getName(), e);
    }
}
