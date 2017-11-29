package com.duellertest.com;


import com.google.firebase.firestore.GeoPoint;

public class DuelModel {

    private String skill;
    private String [] participants;
    private GeoPoint location;

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
