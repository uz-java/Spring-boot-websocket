package com.example.springbootwebsocket.domains;

/**
 * @author "Tojaliyev Asliddin"
 * @since 24/08/22 23:12 (Wednesday)
 * Spring-boot-websocket/IntelliJ IDEA
 */
public class OutputMessage {
    private String from;
    private String text;
    private String time;

    public OutputMessage() {

    }

    public OutputMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
