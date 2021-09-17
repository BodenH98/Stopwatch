package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = "MainActivity"
        val BUNDLE_SWITCHED = "switched"
        val BUNDLE_TIME = "time"
    }
    lateinit var startButton: Button
    lateinit var resetButton: Button
    lateinit var timer:Chronometer
    lateinit var layout: ConstraintLayout
    var switched: Boolean = false
    var time = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wireWidgets()

    startButton.setOnClickListener{
        if(switched){
            timer.stop()
            time = SystemClock.elapsedRealtime() - timer.base
            startButton.text = "Resume"

        }
        else{
            timer.start()
            timer.base = SystemClock.elapsedRealtime() - time
            startButton.text = "stop"
        }
        switched = !switched
    }

    resetButton.setOnClickListener {
        if(switched){
            startButton.callOnClick()
        }
        time = 0L
        timer.base = SystemClock.elapsedRealtime()
        switched = !switched
    }

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(switched){
            time = SystemClock.elapsedRealtime() - timer.base
        }
        outState.putBoolean(BUNDLE_SWITCHED,switched)
        outState.putLong(BUNDLE_TIME, time)


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        switched = savedInstanceState.getBoolean(BUNDLE_SWITCHED)
        time = savedInstanceState.getLong(BUNDLE_TIME)
        timer.base = SystemClock.elapsedRealtime() - time
        if(switched){
            timer.start()
            startButton.text = "stop"
        }
    }


    private fun wireWidgets(){
    startButton = findViewById(R.id.Start)
    resetButton = findViewById(R.id.Reset)
    timer = findViewById(R.id.chronometer_main_stopwatch)
    }
}