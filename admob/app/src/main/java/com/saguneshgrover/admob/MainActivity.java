package com.saguneshgrover.admob;

/*---
App Author : Sagunesh Grover
Website : www.saguneshgrover.com

--- */
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;

    InterstitialAd mInterstitialAd;
    public static final String MY_PREFS_NAME = "admobads";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String badd = prefs.getString("badd", "badd");
        String iadd = prefs.getString("iadd", "iadd");

        if (badd != null) {
             badd = prefs.getString("badd", "badd");
        }
        if (badd != null) {
            iadd = prefs.getString("iadd", "iadd");
        }

        //Add this in OnCreate of Activity to initialize the ad
        MobileAds.initialize(getApplicationContext(), badd);
        //Add this wherever your code needs to add the ad
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        // Create a banner ad
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.LARGE_BANNER);
        mAdView.setAdUnitId(badd);
        // Create an ad request.
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        // Optionally populate the ad request builder.
        adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        // Add the AdView to the view hierarchy.
        layout.addView(mAdView);
        // Start loading the ad.
        mAdView.loadAd(adRequestBuilder.build());
        setContentView(layout);


        //loading insterstial ad
        mInterstitialAd = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(iadd);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });



    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
