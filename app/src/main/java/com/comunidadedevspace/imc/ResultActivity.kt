package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val  KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

            val tvResult = findViewById<TextView>(R.id.tv_Result)
            val tvClassificacao = findViewById<TextView>(R.id.tv_Classificao)
            tvResult.text = result.toString()

            var (classificacao : String , color :Int ) = when { result <= 18.5 -> {
                "UNDER THE WEIGHT" to R.color.Magreza
            }
                result > 18.5f && result <= 24.9f -> {
                    "NORMAL" to R.color.Normal
                }
                result > 25f && result <= 29.9f -> {
                    "OVERWEIGHT" to R.color.Sobrepeso
                }
                result > 30f && result <= 39.9f -> {
                    "OBESITY 1" to R.color.Obesidade
                }
                else ->{
                    "OBESITY 2" to R.color.ObesidadeGrave
                }
            }
            tvClassificacao.setTextColor(ContextCompat.getColor(this ,color))
            tvClassificacao.text= classificacao

1


            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }
}