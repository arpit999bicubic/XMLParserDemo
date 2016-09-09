package com.bicubic.xmlparserdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Live> liveList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.listView1);

        List<Players> playerses = null;


        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            InputStream is=getAssets().open("ranking.xml");
            playerses = parser.parse(is);

            ArrayAdapter<Players> adapter =new ArrayAdapter<Players>
                    (this,android.R.layout.simple_list_item_1, playerses);
            listView.setAdapter(adapter);

        } catch (IOException e) {e.printStackTrace();}


        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            InputStream is=getAssets().open("live.xml");
            liveList = parser.parseLive(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
