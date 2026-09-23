package com.example.holayo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Perfil(
    val nombre: String,
    val dato: String,
    val apodo: String?,
    val equipoFutbol: String?
)

class MainActivity : AppCompatActivity() {
    private val perfil = Perfil(
        nombre = "Laura Arnés",
        dato = "Estudio Ingeniería en Informática en la UNAJ",
        apodo = "Lau",
        equipoFutbol = "River Plate"
    )
    private var saludoFormal = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VIDA", "Main -> onCreate")
        setContentView(R.layout.activity_main)

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvDato = findViewById<TextView>(R.id.tvDato)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)

        val comoLlamarme = perfil.apodo ?: perfil.nombre

        tvSaludo.text = "Hola, soy $comoLlamarme"
        tvDato.text = perfil.dato
        perfil.equipoFutbol?.let { equipo ->
            tvDato.append("\nSoy de $equipo")
        }

        btnSaludar.setOnClickListener {
            saludoFormal = !saludoFormal
            tvSaludo.text = if (saludoFormal) {
                "Hola, soy $comoLlamarme"
            } else {
                "¡Buenas! Acá $comoLlamarme"
            }
        }

        val btnIrSegunda = findViewById<Button>(R.id.btnIrSegunda)
        btnIrSegunda.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("nombre", perfil.apodo ?: perfil.nombre)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnCompartir).setOnClickListener {
            val intentCompartir = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "¡Hola! Soy Lau y estoy probando mi app HolaYo.")
            }
            val chooser = Intent.createChooser(intentCompartir, "Compartir perfil usando:")
            startActivity(chooser)
        }
    }
    override fun onStart() { super.onStart(); Log.d("VIDA", "Main -> onStart") }
    override fun onResume() { super.onResume(); Log.d("VIDA", "Main -> onResume") }
    override fun onPause() { super.onPause(); Log.d("VIDA", "Main -> onPause") }
    override fun onStop() { super.onStop(); Log.d("VIDA", "Main -> onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("VIDA", "Main -> onDestroy") }
    override fun onRestart() { super.onRestart(); Log.d("VIDA", "Main -> onRestart") }
}