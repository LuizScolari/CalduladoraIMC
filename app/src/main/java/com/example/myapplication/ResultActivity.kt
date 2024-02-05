package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvclassificacao = findViewById<TextView>(R.id.tv_classificacao)
        val result1 = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result1.toString()

        val classificacao = if(result1 < 18.5f){
            "ABAIXO DO PESO"
        }else if(result1 in 18.5f..24.9f){
            "PESO NORMAL"
        }else if(result1 in 25.0f..29.9f){
            "SOBREPESO"
        }else if(result1 in 30.0f..39.9f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }

        tvclassificacao.text = "Classificação: $classificacao"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}