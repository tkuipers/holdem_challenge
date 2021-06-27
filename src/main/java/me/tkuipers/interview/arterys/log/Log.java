package me.tkuipers.interview.arterys.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Create File Logger.
 */
public class Log {
    private static FileHandler handler;
    private static final String LOG_LOCATION = "/tmp/tkuipers/output.log";
    public static Logger getLogger(String logName) {
        try {
            if(handler == null){
                initializeHandler();
            }
            Logger log = Logger.getLogger(logName);
            log.setUseParentHandlers(false);

            for(var handler : log.getHandlers()){
                log.removeHandler(handler);
            }

            log.setLevel(Level.INFO);
            log.addHandler(handler);
            return log;
        } catch (IOException e) {
            e.printStackTrace();
            return Logger.getLogger(logName);
        }
    }

    private static void initializeHandler() throws IOException {
        handler = new FileHandler(LOG_LOCATION, true);
        handler.setFormatter(new SimpleFormatter());
        handler.setLevel(Level.INFO);
    }
}
