package dk.dma.enav.services.general.notification;

/**
 * A general message that can be broadcast or send to specific receivers. Is especially useful for testing.
 * 
 * @author Kasper Nielsen
 */
public class NotificationMessage {

    private Level level;

    private String notification;

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @return the notification
     */
    public String getNotification() {
        return notification;
    }

    /**
     * @param level
     *            the level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * @param notification
     *            the notification to set
     */
    public void setNotification(String notification) {
        this.notification = notification;
    }

    public enum Level {
        INFO, WARNING;
    }
}
