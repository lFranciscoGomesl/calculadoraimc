package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Associar o xml com MainActivity

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val PesoStr: String = edtPeso.text.toString()
            val AlturaStr: String = edtAltura.text.toString()

            if (PesoStr == "" || AlturaStr == "") {
                Snackbar.make(
                    edtPeso,"Fill in all fields" ,
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val peso = PesoStr.toFloat()
                val altura = AlturaStr.toFloat()

                val AlturaQ2 = altura * altura
                val Resultado = peso / AlturaQ2

                val intent = Intent(this , ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, Resultado)
                startActivity(intent)

                println("Clicou no Butao " + Resultado)
            }

        }


    }
}