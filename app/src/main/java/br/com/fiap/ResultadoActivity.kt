package br.com.fiap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    var peso = 0.0
    var altura = 0.0
    var sexo = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        carregaDados()

        calcular()
    }

    private fun calcular() {
        val imc = peso / (altura * altura)
        tvImc.text = imc.toFixed(2)

        when {
            imc < 18.5 -> {
                tvStatusImc.text = getString(R.string.label_abaixo_peso)
                setaImagem(R.drawable.fem_abaixo)
            }
            imc < 24.9 -> {
                tvStatusImc.text = "Peso ideal"
                setaImagem(R.drawable.fem_ideal)
            }
            imc < 29.9 -> {
                tvStatusImc.text = "Levemente acima do peso"
                setaImagem(R.drawable.fem_sobre)
            }
            imc < 34.9 -> {
                tvStatusImc.text = "Obeso"
                setaImagem(R.drawable.fem_obeso)
            }
            else -> {
                tvStatusImc.text = "Extremamente Obeso"
                setaImagem(R.drawable.fem_extremo_obeso)
            }
        }
    }

    private fun carregaDados() {
        peso = intent.getStringExtra("PESO").toDouble()
        altura = intent.getStringExtra("ALTURA").toDouble()
        sexo = intent.getStringExtra("PESO")
    }

    fun setaImagem(resourceId: Int) {
        ivImc.setImageDrawable(
            ContextCompat.getDrawable(this,
                resourceId))
    }
}
