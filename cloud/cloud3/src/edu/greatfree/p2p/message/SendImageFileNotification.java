package edu.greatfree.p2p.message;

import org.greatfree.message.ServerMessage;
import edu.greatfree.cs.multinode.message.ChatMessageType;

public class SendImageFileNotification extends ServerMessage {

    private byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public SendImageFileNotification(byte[] bytes) {
        super(ChatMessageType.SEND_IMAGE_NOTIFICATION);
        this.bytes = bytes;
    }
}
