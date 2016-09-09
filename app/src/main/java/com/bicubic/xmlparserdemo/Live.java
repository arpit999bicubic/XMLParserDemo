package com.bicubic.xmlparserdemo;

/**
 * Created by admin on 09-Sep-16.
 */
public class Live {


    String tournament,tournament_place,date,time,player_one,player_two;


    public Live(String tournament, String tournament_place, String date, String time, String player_one, String player_two) {
        this.tournament = tournament;
        this.tournament_place = tournament_place;
        this.date = date;
        this.time = time;
        this.player_one = player_one;
        this.player_two = player_two;
    }

    public Live(String tournament, String date, String time, String player_one, String player_two) {
        this.tournament = tournament;
        this.date = date;
        this.time = time;
        this.player_one = player_one;
        this.player_two = player_two;
    }

    public String getTournament_place() {
        return tournament_place;
    }

    public void setTournament_place(String tournament_place) {
        this.tournament_place = tournament_place;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlayer_one() {
        return player_one;
    }

    public void setPlayer_one(String player_one) {
        this.player_one = player_one;
    }

    public String getPlayer_two() {
        return player_two;
    }

    public void setPlayer_two(String player_two) {
        this.player_two = player_two;
    }
}
