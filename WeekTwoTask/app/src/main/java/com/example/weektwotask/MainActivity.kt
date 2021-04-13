package com.example.weektwotask


import android.content.Intent
import android.content.res.Configuration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.view.View

import android.widget.Button

import android.widget.TextView


const val PORTRAIT_COUNTER = "portraitCounter"

class MainActivity : AppCompatActivity() {

    // Initializing the variables for textview ID
    private lateinit var activityStatus: TextView
    private lateinit var orientationStatus: TextView

    /**
     * creating the instance of the handler
     */
    private val handler = Handler()
    var portraitCounter = 0
    var landscapeCounter = 0

    //  FragmentActivity Perform initialization of all view.
    override fun onCreate(savedInstanceState: Bundle?) {
//      Perform initialization of all view
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityStatus = findViewById(R.id.appInstance)

//      Causes the Runnable r to be added to the message queue, to be run after the specified amount of time elapses.
        handler.postDelayed({ activityStatus.text = "onCreate()" }, 1000)

//      Finds a view that was identified by the android:id XML attribute that was processed
        orientationStatus = findViewById(R.id.orientation)

        if (savedInstanceState != null) {
//            store the instance of the app
            portraitCounter = savedInstanceState.getInt(PORTRAIT_COUNTER)
            landscapeCounter = savedInstanceState.getInt("landscapeCounter")
        }

//      Returns a Resources instance for the application's package.
        var orientation = this.resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitCounter++
            orientationStatus.text = "Portrait mode $portraitCounter"

        } else {
            landscapeCounter++
            orientationStatus.text = "Landscape mode $landscapeCounter"

        }

        /**
         *  Adding intent to the button that lead to the next activity
         *
         * */
        val button = findViewById<Button>(R.id.button)
//      Register a callback to be invoked when this button view is clicked
        button.setOnClickListener {
//            Create an intent for a SecondMainActivity component
            val intent = Intent(this, SecondMainActivity::class.java)
            startActivity(intent)
        }

    }

    //  Get the instance saved
    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
//    Save all appropriate fragment state
        super.onSaveInstanceState(outState)
        outState.putInt(PORTRAIT_COUNTER, portraitCounter)
        outState.putInt("landscapeCounter", landscapeCounter)
    }

    //  The onResume code block Method
    override fun onStart() {
        super.onStart()
        handler.postDelayed({ activityStatus.text = "onStart()" }, 2000)
    }


    //  The onResume code block Method
    override fun onResume() {
        super.onResume()
        handler.postDelayed({ activityStatus.text = "onResume()" }, 3000)
    }

    //  The onPause code block Method
    override fun onPause() {
        super.onPause()
        activityStatus.text = "onPause()"
    }

    //  The onStop code block Method
    override fun onStop() {
        super.onStop()
        activityStatus.text = "onStop()"
    }

    //  The onRestart code block Method
    override fun onRestart() {
        super.onRestart()
        activityStatus.text = "onRestart()"
    }

    //  The onDestroy code block Method
    override fun onDestroy() {
        super.onDestroy()
        activityStatus.text = "onDestroy()"
    }
}