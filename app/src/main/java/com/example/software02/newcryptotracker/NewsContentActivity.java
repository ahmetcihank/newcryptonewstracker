package com.example.software02.newcryptotracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsContentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String imageUrl =  getIntent().getExtras().getString("imageUrl");
        String newsTitleStr = getIntent().getExtras().getString("titleText");
        String newsContentStr = getIntent().getExtras().getString("contentText");

        ImageView newsActivityImage = (ImageView) findViewById(R.id.newsActivityImage);
        TextView newsTitleText =(TextView) findViewById(R.id.news_content_title);
        TextView newsContent =(TextView) findViewById(R.id.news_content);

        newsTitleText.setText(newsTitleStr);
        newsContent.setText(newsContentStr);
        Picasso.get().load(imageUrl).into(newsActivityImage);
    }
}
