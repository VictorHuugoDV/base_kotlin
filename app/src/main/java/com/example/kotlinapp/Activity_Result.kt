package com.example.kotlinapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity_Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btYes = findViewById<Button>(R.id.btyes)
        val btNo = findViewById<Button>(R.id.btno)
        val btCancel = findViewById<Button>(R.id.btCancel)

        btYes.setOnClickListener {
            val intent = Intent()

            intent.putExtra("RESULT", getString(R.string.yes))
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
        btNo.setOnClickListener {
            val intent = Intent()

            intent.putExtra("RESULT", getString(R.string.no))
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
        btCancel.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)

            finish()
        }
    }
}