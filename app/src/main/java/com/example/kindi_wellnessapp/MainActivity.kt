package com.example.kindi_wellnessapp

import android.content.Intent
import android.media.tv.AdRequest
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
    private var mInterstitialAd: InterstitialAd?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ads
        MobileAds.initialize(this)
        val adView=findViewById<AdView>(R.id.adView)
        val adRequest= com.google.android.gms.ads.AdRequest.Builder().build()
        adView.loadAd(adRequest)

        loadInterstitialAd()

        // find our views
        val healthy_recipes=findViewById<Button>(R.id.healthy_recipes)
        healthy_recipes.setOnClickListener {
            val intent= Intent(applicationContext, HealthyRecipes::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val nutrition_advice=findViewById<Button>(R.id.nutrition_advice)
        nutrition_advice.setOnClickListener {
            val intent= Intent(applicationContext, NutritionAdvice::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val check_progress=findViewById<Button>(R.id.check_progress)
        check_progress.setOnClickListener {
            val intent= Intent(applicationContext, CheckProgress::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val daily_motivation=findViewById<Button>(R.id.daily_motivation)
        daily_motivation.setOnClickListener {
            val intent= Intent(applicationContext, DailyMotivation::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val hydration_alert=findViewById<Button>(R.id.hydration_alert)
        hydration_alert.setOnClickListener {
            val intent= Intent(applicationContext, HydrationAlert::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val meditation=findViewById<Button>(R.id.meditation)
        meditation.setOnClickListener {
            val intent= Intent(applicationContext, Meditation::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val start_exercise=findViewById<Button>(R.id.start_exercise)
        start_exercise.setOnClickListener {
            val intent= Intent(applicationContext, StartExercise::class.java)
            startActivity(intent)
            showInterstitialAd()
        }

        val weekly_goals=findViewById<Button>(R.id.weekly_goals)
        weekly_goals.setOnClickListener {
            val intent= Intent(applicationContext, WeeklyGoals::class.java)
            startActivity(intent)
            showInterstitialAd()
        }
    }
    fun loadInterstitialAd(){
        val adRequst= com.google.android.gms.ads.AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequst,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(ad: InterstitialAd) {
                    mInterstitialAd=ad

                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    mInterstitialAd=null
                }
            }
        )
    }
    fun showInterstitialAd(){
        if (mInterstitialAd!=null){
            mInterstitialAd?.show(this)
        }
    }
}