/* Copyright (c) 2011 Danish Maritime Authority
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dma.enav.service.general.notification;

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
