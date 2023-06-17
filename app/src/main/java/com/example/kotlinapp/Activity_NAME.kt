package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_NAME : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val tvResult=findViewById<TextView>(R.id.tvResult)
        val nomeDigitado=intent.getStringExtra("NOME_DIGITADO")

        tvResult.text=nomeDigitado
    }
}