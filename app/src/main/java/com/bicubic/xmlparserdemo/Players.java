package com.bicubic.xmlparserdemo;

/**
 * Created by admin on 06-Sep-16.
 */
public class Players {

    private String player_name,rank, movement, country,points;


    public Players(String player_name, String rank, String movement, String country, String points) {
        this.player_name = player_name;
        this.rank = rank;
        this.movement = movement;
        this.country = country;
        this.points = points;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return " rank = "+rank + "\n Name= " + player_name + "\n Salary= " + points +"\n Country = "+country+"\n movement = "+movement;

    }


}
