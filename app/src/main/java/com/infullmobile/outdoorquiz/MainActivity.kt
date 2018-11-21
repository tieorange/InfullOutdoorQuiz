package com.infullmobile.outdoorquiz

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.view.MotionEvent.BUTTON_PRIMARY
import android.view.MotionEvent.BUTTON_SECONDARY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            showSnackback("Replace with your own action")
        }
    }

    private fun showSnackback(text: String) {
        Snackbar.make(fab, text, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }


    private fun onLeftClicked() {
        showSnackback("left")
    }

    private fun onRightClicked() {
        showSnackback("right")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false

        Log.d(MainActivity::class.java.simpleName, event.toString())

        when (event.buttonState) {
            BUTTON_PRIMARY -> onLeftClicked()
            BUTTON_SECONDARY -> onRightClicked()
            else -> return super.onTouchEvent(event)
        }

        return super.onTouchEvent(event)
    }
}
