package com.geek.a01_primerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class activitymsm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitymsm)

        val bundle=intent.extras
        val dnombres=bundle?.getString("dato01")
        val dapellido=bundle?.getString("dato02")
        val dgenero=bundle?.getString("dato03")
        val dfecha=bundle?.getString("dato04")
        val dtelefono=bundle?.getString("dato05")
        val detnia=bundle?.getString("dato06")


        var t: TextView=findViewById(R.id.LblTitulo2)
        t.setText("Bienvenido: "+dnombres+" "+dapellido +"\n"+
                "Con Genero: "+dgenero+ "'\n"+
                "Con fecha de Nacimiento: " +dfecha +"'\n"+
                "Con Telefono: " +dtelefono +"'\n"+
                "Con Etnia: " +detnia)

//        t.setText("dsdsdsdsdsdsds")

//        Toast.makeText(this, dato,Toast.LENGTH_LONG).show()

    }
}