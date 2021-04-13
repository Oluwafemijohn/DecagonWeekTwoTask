package com.example.weektwotask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second_main.*


class SecondMainActivity : AppCompatActivity() {
    //   Initializing the variables for textview ID
    lateinit var welcomeText: TextView

    //  Initializing the variables for textview ID
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main)

//   Create the instance of the fragment method
        val firstFragment = FirstFragment()

//      A textView on the activity
        welcomeText = findViewById(R.id.second_activity_textView1)
        welcomeText.text = "Welcome to the implementation 2. Press ( <-- ) to go back"


//    Initializing the support manager
        val fragmentManager = supportFragmentManager
        addFragment.setOnClickListener {
//            Getting the number of of entries in the back stack
            var fragmentCount = fragmentManager.backStackEntryCount
//            Start a series of edit operations on the Fragments associated with this FragmentManager.
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutFragmentId, FirstFragment.newInstance("$fragmentCount"))
                addToBackStack(null)
                commit()
            }
        }
//        Register a callback to be invoked when this view is clicked.
        this.removeFragment.setOnClickListener {
            fragmentManager.popBackStack()
        }

    }

}