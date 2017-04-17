package taursus.remoteControlClient;

import android.util.Log;

import taursus.remoteControl.ILogger;

public class Logger implements ILogger {
    protected static class LoggerLoader {
        private static final Logger INSTANCE = new Logger();
    }

    protected Logger() {
        if (LoggerLoader.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    public static Logger getInstance() {
        return LoggerLoader.INSTANCE;
    }

    @Override
    public void log(String type, String message) {
        Log.d(type, message);
    }
}
