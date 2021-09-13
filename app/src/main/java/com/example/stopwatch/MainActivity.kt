package com.example.stopwatch

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import android.widget.Switch
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object{
        val TAG = "MainActivity"
    }
    lateinit var startButton: Button
    lateinit var resetButton: Button
    lateinit var timer:Chronometer
    lateinit var layout: ConstraintLayout
    var Switched: Boolean = false
    var time = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wireWidgets()

    startButton.setOnClickListener{
        if(Switched){
            timer.stop()
            time = SystemClock.elapsedRealtime() - timer.base
            startButton.text = "Resume"

        }
        else{
            timer.start()
            timer.base = SystemClock.elapsedRealtime() - time
            startButton.text = "stop"
        }
        Switched = !Switched
    }

    resetButton.setOnClickListener {
        if(Switched){
            startButton.callOnClick()
        }
        time = 0L
        timer.base = SystemClock.elapsedRealtime()
        Switched = !Switched
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



    private fun wireWidgets(){
    startButton = findViewById(R.id.Start)
    resetButton = findViewById(R.id.Reset)
    timer = findViewById(R.id.chronometer_main_stopwatch)
    }
}