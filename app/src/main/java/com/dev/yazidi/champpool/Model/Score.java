package com.dev.yazidi.champpool.Model;

public class Score {
    private long id;
    private String champion;
    private String lane;
    private int score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Score() {
    }

    public Score(String champion, String lane, int score) {
        this.champion = champion;
        this.lane = lane;
        this.score = score;
    }

    public Score(long id, String champion, String lane, int score) {
        this.id = id;
        this.champion = champion;
        this.lane = lane;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", champion='" + champion + '\'' +
                ", lane='" + lane + '\'' +
                ", score=" + score +
                '}';
    }
}
