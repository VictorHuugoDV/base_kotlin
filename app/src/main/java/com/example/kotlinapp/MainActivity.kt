package com.example.kotlinapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etNome = findViewById<EditText>(R.id.etNome)
        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val btEnviar2 = findViewById<Button>(R.id.btEnviar2)
        val btEnviar3 = findViewById<Button>(R.id.btEnviar3)

        btEnviar.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                tvResultado.text = getString(R.string.hello_name, etNome.text)
            } else {
                etNome.error = getString(R.string.type_your_name)
            }
        }
        btEnviar2.setOnClickListener {
            if (etNome.text.isNotBlank()) {
                val nomeDigitado = etNome.text.toString()

                val intent = Intent(this, Activity_NAME::class.java)

                intent.putExtra("NOME_DIGITADO", nomeDigitado)
                startActivity(intent)

            } else {
                etNome.error = getString(R.string.type_your_name)
            }
        }
        btEnviar3.setOnClickListener {
            val intent = Intent(this, Activity_Result::class.java)

            val requestcode = 1
            startActivityForResult(intent, requestcode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                val Result = data.getStringExtra("RESULT")

                val tvResultado = findViewById<TextView>(R.id.tvResultado)
                tvResultado.text = Result
            }else if(resultCode==Activity.RESULT_CANCELED){
                val tvResultado = findViewById<TextView>(R.id.tvResultado)
                tvResultado.text =getString(R.string.result_canceled)
            }
        }
    }
}

