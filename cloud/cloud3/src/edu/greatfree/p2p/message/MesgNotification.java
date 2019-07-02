package edu.greatfree.p2p.message;

import edu.greatfree.cs.multinode.message.ChatMessageType;
import org.greatfree.message.ServerMessage;
import org.greatfree.message.container.Notification;
import org.greatfree.util.UtilConfig;

//public class MesgNotification extends ServerMessage
public class MesgNotification extends Notification
{
    private static final long serialVersionUID = -4180547758940870394L;

    // The chatting message
    private String message;
    // The sender name
    private String senderName;

    public MesgNotification(String message, String senderName)
    {
        super(ChatMessageType.PEER_CHAT_NOTIFICATION);
        this.message = message;
        this.senderName = senderName;
    }

    public MesgNotification(String message)
    {
        super(ChatMessageType.PEER_CHAT_NOTIFICATION);
        this.message = message;
        this.senderName = UtilConfig.EMPTY_STRING;
    }

    public String getMessage()
    {
        return this.message;
    }

    public String getSenderName()
    {
        return this.senderName;
    }
}
