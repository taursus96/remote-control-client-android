package taursus.remoteControlClient;

import taursus.remoteControl.ILogger;

public class LoggerFactory {

    public static ILogger create() {
        return Logger.getInstance();
    }
}
