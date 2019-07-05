package edu.greatfree.p2p.message;

import edu.greatfree.cs.multinode.message.ChatMessageType;
import org.greatfree.message.ServerMessage;


public class SendNotification extends ServerMessage {

    private String filePath;
    private String fileName;
    private String senderName;
    private byte[] bytes ;

    public SendNotification(String filePath, String name, /*String senderName, */byte[] bytes) {
        super(ChatMessageType.SEND_FILE_NOTIFICATION);
        this.filePath = filePath;
        this.fileName = name;
        this.bytes = bytes;
    }

    public SendNotification() {
        super(ChatMessageType.SEND_FILE_NOTIFICATION);
    }

    public String getfilePath() {
        return filePath;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getFileNmae() {return this.fileName;}

    public byte[] getBytes() {
        return bytes;
    }

}
