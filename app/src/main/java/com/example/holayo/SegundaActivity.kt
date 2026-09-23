package com.example.holayo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActivity : AppCompatActivity() {
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VIDA", "Segunda -> onCreate")
        setContentView(R.layout.activity_segunda)
        val nombre = intent.getStringExtra("nombre") ?: "misterioso visitante"
        findViewById<TextView>(R.id.tvBienvenida).text =
            "Sala de experimentos de $nombre"
        val tvContador = findViewById<TextView>(R.id.tvContador)
        tvContador.text = contador.toString()
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("VALOR_CONTADOR", 0)
            tvContador.text = contador.toString()
            Log.d("VIDA", "Segunda -> Recuperé el contador: $contador")
        }
        findViewById<Button>(R.id.btnSumar).setOnClickListener {
            contador++
            tvContador.text = contador.toString()
        }
    }
    override fun onStart() { super.onStart(); Log.d("VIDA", "Segunda -> onStart") }
    override fun onResume() { super.onResume(); Log.d("VIDA", "Segunda -> onResume") }
    override fun onPause() { super.onPause(); Log.d("VIDA", "Segunda -> onPause") }
    override fun onStop() { super.onStop(); Log.d("VIDA", "Segunda -> onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("VIDA", "Segunda -> onDestroy") }
    override fun onRestart() { super.onRestart(); Log.d("VIDA", "Segunda -> onRestart") }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("VALOR_CONTADOR", contador)
        Log.d("VIDA", "Segunda -> Guardé el contador: $contador")
    }
}