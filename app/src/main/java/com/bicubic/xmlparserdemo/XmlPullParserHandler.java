package com.bicubic.xmlparserdemo;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 06-Sep-16.
 */
public class XmlPullParserHandler {

    private static final String TAG = "XmlPullParserHandler";
    private List<Players> playerses = new ArrayList<Players>();
    private List<Live> liveList = new ArrayList<Live>();
    private Players players;
    private String text;
    private String player_name = "", rank = "",movement = "", points = "", country = "";

    public List<Players> getPlayerses() {
        return playerses;
    }

    public List<Players> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("players")) {
                            // create a new instance of players
//                            players = new Players();



                        }
                        /*if (tagname.equalsIgnoreCase("manager"))
                        {
                            Log.d(TAG, "parse: manager pass start tag");
                        }*/
                        break;

                    case XmlPullParser.TEXT:

//                        text = parser.getText();
//                        Log.i(TAG, "parse: text: "+text);

                        break;

                    case XmlPullParser.END_TAG:

                        player_name = parser.getAttributeValue(null,"name");
                        rank = parser.getAttributeValue(null,"rank");
                        movement = parser.getAttributeValue(null,"movement");
                        country = parser.getAttributeValue(null,"country");
                        points = parser.getAttributeValue(null,"points");

                        Log.d(TAG, "parse: name : "+player_name+" rank = "+rank+" movement = "+movement+ " country = "+country+" points = "+points );

                        playerses.add(new Players(player_name,rank,movement,country,points ));

                       /* if (tagname.equalsIgnoreCase("players")) {
                            // add players object to list
                            playerses.add(players);
                        }else if (tagname.equalsIgnoreCase("id")) {
                            players.setId(Integer.parseInt(text));
                        }  else if (tagname.equalsIgnoreCase("name")) {
                            players.setName(text);
                        } else if (tagname.equalsIgnoreCase("salary")) {
                            players.setSalary(Float.parseFloat(text));
                        }

                        if (tagname.equalsIgnoreCase("name"))
//                            Log.d(TAG, "parse: name: "+text);*/
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return playerses;
    }


    public List<Live> parseLive(InputStream is) {
        try {

            String tournament = null,tournament_place = null,date = null,time = null,status = null,player_one = null,player_two = null;

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
           
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        if ("category".equals(tagname)){

                            tournament = parser.getAttributeValue(null,"name");
                            tournament_place = parser.getAttributeValue(null,"city");

                        }

                        if ("match".equals(tagname)){

                            date = parser.getAttributeValue(null,"date");
                            time = parser.getAttributeValue(null,"time");
                            status = parser.getAttributeValue(null,"status");

                        }

                        if ("player".equals(tagname) && "0".equals(String.valueOf(parser.getAttributeName(1)))){

                            Log.d(TAG, "parseLive: no = "+parser.getColumnNumber());
                            player_one = parser.getAttributeValue(null,"name");

                        }
                        if ("player".equals(tagname) && "1".equals(String.valueOf(parser.getColumnNumber()))){

                            player_two = parser.getAttributeValue(null,"name");

                        }

                        break;

                    case XmlPullParser.TEXT:

//                        text = parser.getText();
//                        Log.i(TAG, "parse: text: "+text);

                        break;

                    case XmlPullParser.END_TAG:


                        Log.d(TAG, "parse: tournament : "+tournament+" tournament_place = "+tournament_place+" date = "+date+ " time = "+time+" status = "+status +" player_one = "+player_one +" player_two = "+player_two);

                        liveList.add(new Live(tournament,tournament_place,date,time,player_one,player_two));

                       /* if (tagname.equalsIgnoreCase("players")) {
                            // add players object to list
                            playerses.add(players);
                        }else if (tagname.equalsIgnoreCase("id")) {
                            players.setId(Integer.parseInt(text));
                        }  else if (tagname.equalsIgnoreCase("name")) {
                            players.setName(text);
                        } else if (tagname.equalsIgnoreCase("salary")) {
                            players.setSalary(Float.parseFloat(text));
                        }

                        if (tagname.equalsIgnoreCase("name"))
//                            Log.d(TAG, "parse: name: "+text);*/
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return liveList;
    }


}
