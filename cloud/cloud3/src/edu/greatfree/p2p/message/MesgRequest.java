package edu.greatfree.p2p.message;

import edu.greatfree.cs.multinode.message.ChatMessageType;
import org.greatfree.message.ServerMessage;

public class MesgRequest extends ServerMessage {
    private static final long serialVersionUID = 3239511889796307819L;

    private String partnerKey;

    public MesgRequest(String partnerKey)
    {
        super(ChatMessageType.PEER_CHAT_PARTNER_REQUEST);
        this.partnerKey = partnerKey;
    }

    public String getPartnerKey()
    {
        return this.partnerKey;
    }

}
