package edu.greatfree.p2p.peer;

import edu.greatfree.p2p.message.SendNotification;
import org.greatfree.concurrency.interactive.NotificationQueue;
import org.greatfree.data.ServerConfig;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Author Daria
 * @Description
 * @Date 2019/7/2 -- 14:19
 */
public class ReceNotificationThread extends NotificationQueue<SendNotification> {
    public ReceNotificationThread(int taskSize)
    {
        super(taskSize);
    }

    @Override
    public void run()
    {
        SendNotification notification;
        while (!this.isShutdown())
        {
            while (!this.isEmpty())
            {
                try
                {
//                    System.out.println("jkgjalkgjlkjglkjaklgjlkag");
                     notification = this.getNotification();

                    String filename = "D:\\abc\\"+notification.getFileNmae();
                    System.out.println(filename);
                    OutputStream outputStream = null;
                    try {
                        outputStream = new FileOutputStream(new File(filename));
                        outputStream.write(notification.getBytes());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(notification.getFileNmae() + "发送成功");
                    this.disposeMessage(notification);
            }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                // Wait for a moment after all of the existing notifications are processed. 01/20/2016, Bing Li
                this.holdOn(ServerConfig.NOTIFICATION_THREAD_WAIT_TIME);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}
