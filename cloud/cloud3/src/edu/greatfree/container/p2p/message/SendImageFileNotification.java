package edu.greatfree.container.p2p.message;

import edu.greatfree.cs.multinode.message.ChatMessageType;
import org.greatfree.message.container.Notification;


public class SendImageFileNotification extends Notification {

    private byte[] bytes;

    private String fileName;

    public byte[] getBytes() {
        return bytes;
    }

    public String getFileName() {
        return fileName;
    }

    public SendImageFileNotification(byte[] bytes, String fileName) {
        super(P2PChatApplicationID.SEND_IMAGE_NOTIFICATION);
        this.bytes = bytes;
        this.fileName = fileName;
    }
}
