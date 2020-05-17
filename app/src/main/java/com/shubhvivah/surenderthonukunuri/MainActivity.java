package com.shubhvivah.surenderthonukunuri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView inter1,book2,book3,book4,book5,SuperBook;
    AdView adView1;
    private InterstitialAd mInterstitialAd;

    private Button media;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        prepareAd();
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                Log.i("hello", "world");
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", " Interstitial not loaded");
                        }
                        prepareAd();
                    }
                });
            }
        }, 60, 60, TimeUnit.SECONDS);
    }
    public void prepareAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8227003823560716/3065031287");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        MobileAds.initialize(this,"ca-app-pub-8227003823560716/5747034943");
        adView1 = findViewById(R.id.ad_view1);
        MobileAds.initialize(this,"ca-app-pub-8227003823560716/5747034943");
        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);


        inter1 = (CardView)findViewById(R.id.inter1);
        book2 = (CardView)findViewById(R.id.mybook2);
        book3 = (CardView)findViewById(R.id.mybook3);
        book4 = (CardView)findViewById(R.id.mybook4);
        book5 = (CardView)findViewById(R.id.mybook5);
        SuperBook = (CardView)findViewById(R.id.SuperBook);
        media = (Button) findViewById(R.id.media);

        inter1.setOnClickListener(this);
        book2.setOnClickListener(this);
        book3.setOnClickListener(this);
        book4.setOnClickListener(this);
        book5.setOnClickListener(this);
        SuperBook.setOnClickListener(this);
        media.setOnClickListener(this);}

    @Override
    public void onClick(View v) {

        Intent i ;

        switch (v.getId()) {
            case R.id.inter1: i = new Intent(this,mybook.class);startActivity(i);break;
            case R.id.mybook2: i = new Intent(this,mybook2.class);startActivity(i);break;
            case R.id.mybook3: i = new Intent(this,mybook3.class);startActivity(i);break;
            case R.id.mybook4: i = new Intent(this,mybook4.class);startActivity(i);break;
            case R.id.mybook5: i = new Intent(this,mybook5.class);startActivity(i);break;
            case R.id.SuperBook: i = new Intent(this,SuperBook.class);startActivity(i);break;
            case R.id.media: i = new Intent(this,media.class);startActivity(i);break;

            default:break; } }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private static class Builder {
        public static void addTestDevice(String s) {
        }


    }
}
