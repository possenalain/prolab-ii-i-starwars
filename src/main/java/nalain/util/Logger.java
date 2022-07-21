package nalain.util;

public class Logger {
    private static Logger logger = null;
    private String message = "";
    private Logger() {
    }

    public Logger getInstance() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void log(String log) {
        this.message += log + "\n";
    }

    public String getLogs() {
        return this.message.toString();
    }

    public void clearLogs() {
        this.message = " ";
    }
}
