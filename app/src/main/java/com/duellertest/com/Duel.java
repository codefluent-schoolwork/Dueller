package com.duellertest.com;


import com.google.firebase.firestore.GeoPoint;

public class Duel {

    private String skill;
    private String [] participants;
    private GeoPoint location;

    public Duel() {}

    public Duel(String skill, String [] participants, GeoPoint location) {
        this.skill = skill;
        this.participants = participants;
        this.location = location;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String[] getParticipants() {
        return participants;
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}
