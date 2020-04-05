package com.company.behavioral.chain_of_responsibility.error_handler;

public class Message {

    private String text;
    private MessagePriority priority;

    public Message(String text, MessagePriority priority) {
        this.text = text;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public MessagePriority getPriority() {
        return priority;
    }
}
