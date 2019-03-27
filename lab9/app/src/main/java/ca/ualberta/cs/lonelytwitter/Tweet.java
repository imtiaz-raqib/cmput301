package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {

    private String message;
    private Date date;

    public Tweet() {
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

}