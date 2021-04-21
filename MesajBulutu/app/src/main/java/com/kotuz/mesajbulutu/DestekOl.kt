package com.kotuz.mesajbulutu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_ayarlar.*
import kotlinx.android.synthetic.main.activity_destek_ol.*

const val GAME_LENeGTH_MeILLISECONDSae = 3000L
const val AD_UeNIT_eIDae = "ca-app-pub-6537190103014639/1336900383"


class DestekOl : AppCompatActivity() {
    private var mAdView: AdView? = null
    private lateinit var mInterstitialAd: InterstitialAd
    private var mCountDownTimer: CountDownTimer? = null
    private var mGameIsInProgress = false
    private var mTimerMilliseconds = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destek_ol)




        yorumYap.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=com.kotuz.mesajbulutu")     //herhangi bi sitenin domain adresi yardımı ile o hosting adresine ulaşmasına sağlıyor
            startActivity(intent)

        }

            // Initialize the Mobile Ads SDK.
            MobileAds.initialize(this)

            // Create the InterstitialAd and set it up.
            mInterstitialAd = InterstitialAd(this).apply {
                adUnitId = AD_UeNIT_eIDae
                adListener = (object : AdListener() {
                    override fun onAdLoaded() {
                    }

                    override fun onAdFailedToLoad(errorCode: Int) {

                    }

                    override fun onAdClosed() {

                        startGame()
                        Toast.makeText(applicationContext, "Çok teşekkür ederiz", Toast.LENGTH_SHORT).show()
                        reklamIzle.text="Tekrar İzle"

                    }
                })
            }

            // Create the "retry" button, which triggers an interstitial between game plays.
            reklamIzle.setOnClickListener { showInterstitial() }


            // Kick off the first play of the "game."
            startGame()
        }


        // Create the game timer, which counts down to the end of the level
// and shows the "retry" button.
        private fun createTimer(milliseconds: Long) {
            mCountDownTimer?.cancel()

            mCountDownTimer = object : CountDownTimer(milliseconds, 50) {
                override fun onTick(millisUntilFinished: Long) {
                    mTimerMilliseconds = millisUntilFinished
                }

                override fun onFinish() {
                    mGameIsInProgress = false
                }
            }
        }

        // Show the ad if it's ready. Otherwise toast and restart the game.
        private fun showInterstitial() {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()


            } else {
                Toast.makeText(this, "Lüten baglantınızı kontrol edip tekrar deneyiniz", Toast.LENGTH_SHORT).show()
                startGame()

            }
        }

        // Request a new ad if one isn't already loaded, hide the button, and kick off the timer.
        private fun startGame() {
            if (!mInterstitialAd.isLoading && !mInterstitialAd.isLoaded) {
                // Create an ad request. If you're running this on a physical device, check your logcat
                // to learn how to enable test ads for it. Look for a line like this one:
                // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
                val adRequest = AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .build()

                mInterstitialAd.loadAd(adRequest)


            }

            resumeGame(GAME_LENeGTH_MeILLISECONDSae)
        }

        private fun resumeGame(milliseconds: Long) {
            // Create a new timer for the correct length and start it.
            mGameIsInProgress = true
            mTimerMilliseconds = milliseconds
            createTimer(milliseconds)
            mCountDownTimer?.start()
        }

        // Resume the game if it's in progress.
        public override fun onResume() {
            super.onResume()

            if (mGameIsInProgress) {
                resumeGame(mTimerMilliseconds)
            }
        }

        // Cancel the timer if the game is paused.
        public override fun onPause() {
            mCountDownTimer?.cancel()
            super.onPause()
        }

}