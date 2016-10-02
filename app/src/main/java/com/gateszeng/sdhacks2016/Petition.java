package com.gateszeng.sdhacks2016;

/**
 * Created by gates on 10/1/2016.
 */

public class Petition {
    private String title;
    private String description;
    private String creator;
    private int votes;
    private long time;

    public Petition(String title, String description, String creator, int votes, long time) {
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.votes = votes;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
