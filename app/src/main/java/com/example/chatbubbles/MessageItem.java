package com.example.chatbubbles;

import java.sql.Time;

public class MessageItem {
    public enum MessageType {
        Chat, Notice
    }

    public MessageType messageType;

    private MessageItem(MessageType type)
    {
        this.messageType = type;
    }

    public static class ChatMessage extends MessageItem {
        public String textMessage;
        public String imageMessage;
        public Time sendTime;
        public boolean isSend;


        public ChatMessage(String textMessage, String imageMessage, Time sendTime, boolean isSend)
        {
            super(MessageType.Chat);
            this.imageMessage = imageMessage;
            this.textMessage = textMessage;
            this.sendTime = sendTime;
            this.isSend = isSend;
        }
    }

    public static class NoticeMessage extends MessageItem {
        public String notice;


        public NoticeMessage(String notice)
        {
            super(MessageType.Notice);
            this.notice = notice;
        }
    }
}
