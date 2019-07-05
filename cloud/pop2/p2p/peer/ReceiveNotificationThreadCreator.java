package edu.greatfree.p2p.peer;

import edu.greatfree.p2p.message.SendNotification;
import org.greatfree.concurrency.interactive.NotificationThreadCreatable;

/**
 * @Author Daria
 * @Description
 * @Date 2019/7/2 -- 14:19
 */
public class ReceNotificationThreadCreator implements NotificationThreadCreatable<SendNotification, ReceNotificationThread> {
    @Override
    public ReceNotificationThread createNotificationThreadInstance(int taskSize) {
        return new ReceNotificationThread(taskSize);
    }
}
