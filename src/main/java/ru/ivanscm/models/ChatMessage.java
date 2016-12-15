package ru.ivanscm.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IvanSCM on 15.12.2016.
 */
public class ChatMessage implements Serializable {
    private String username;
    private Date dateTime;
    private String message;

    protected SimpleDateFormat messageDateFormat;

    public ChatMessage() {
        super();
    }

    public ChatMessage(String username, Date dateTime, String message) {
        super();
        this.username = username;
        this.dateTime = dateTime;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPrintableDate() {
        messageDateFormat = new SimpleDateFormat("dd.MM.yyyy 'в' hh:mm:ss");
        return messageDateFormat.format(this.dateTime);
    }
}
