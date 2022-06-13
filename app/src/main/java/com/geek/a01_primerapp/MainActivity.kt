package com.geek.a01_primerapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.datepicker.MaterialDatePicker


import java.time.Month
import java.time.Year
import android.widget.TextView as TextView1


class MainActivity : AppCompatActivity() {

    //Variable para enviar


    //Variables para Etnias
    lateinit var optionEtniasSp: Spinner
    lateinit var resultEtnias: String
    var optionsEtnias= arrayOf("Mestizo","Blanco","Negro")

    //Variables para Generos
    lateinit var optionGenerosSp: Spinner
    lateinit var resultGeneros: String
    var optionsGeneros= arrayOf("Hombre","Mujer","Helipcotero Apache","No especifico")

    //Variables Para las Cuadros de Texto
    lateinit var txtnombres: EditText
    lateinit var txtapellidos: EditText
    lateinit var txttelefono: EditText
    lateinit var txtfec: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtfec=findViewById(R.id.etDate)
        txtfec.setOnClickListener { showDatePickerDialog()}

        AgregaGenero()
        AgregaEtnia()

        SalvaTxt()

    }


    //Muestra El Calendario
    private fun showDatePickerDialog(){
        val datePicker =DatePickerFragment {day,month,year ->  onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    //Escoge la Fecha
    fun onDateSelected(day:Int,month: Int,year: Int)
    {
            txtfec.setText("Esxogiste tal fecha")
    }

    //Agrega Items al Spinner de Etnias
    private fun AgregaEtnia()
    {
        optionEtniasSp=findViewById(R.id.ListEtnias) as Spinner
        //Datos del Spiner
        //var options= arrayOf("Mestizo","Blanco","Negro")

        //Llenamos el Spiner
        optionEtniasSp.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,optionsEtnias)
    }

    //Agrega Items al Spinner de Generos
    private fun AgregaGenero()
    {
        optionGenerosSp=findViewById(R.id.ListGeneros) as Spinner
        //Datos del Spiner
        //var options= arrayOf("Mestizo","Blanco","Negro")

        //Llenamos el Spiner
        optionGenerosSp.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,optionsGeneros)
    }

    //Escoge el Genero
    private fun EscogerGenero() {
        optionGenerosSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //Salvamos la opcion Escogida
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                resultGeneros = optionsGeneros.get(position)
            }

            //En caso de que no escoga nada, se guarda esa iteracion
            override fun onNothingSelected(parent: AdapterView<*>?) {
                resultGeneros = "Escoga una opcion"
            }
        }
    }

    //Escoge la Etnia
    private fun EscogerEtnia()
    {
        optionEtniasSp.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            //Salvamos la opcion Escogida
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                resultEtnias=optionsEtnias.get(position)
            }
            //En caso de que no escoga nada, se guarda esa iteracion
            override fun onNothingSelected(parent: AdapterView<*>?) {
                resultEtnias="Escoga una opcion"
            }
        }

    }

    //Capturamos los Datos
    private fun SalvaTxt()
    {
        txtnombres=findViewById(R.id.TxtNombres)
        txtapellidos=findViewById(R.id.TxtApellidos)
        txttelefono=findViewById(R.id.TxtTelefono)
        EscogerGenero()
        EscogerEtnia()
        var boton: Button=findViewById(R.id.BtnEnviar)

        boton.setOnClickListener{
            val intent= Intent(this,activitymsm::class.java)
            //Salvamos Valores
            var d1:String =txtnombres.text.toString()
            var d2:String =txtapellidos.text.toString()
            var d3:String =resultGeneros.toString()
            var d4:String =txtfec.text.toString()
            var d5 :String=txttelefono.toString()
            var d6:String=resultEtnias.toString()


            //Agregamos Parametros
            intent.putExtra("dato01", d1)
            intent.putExtra("dato02", d2)
            intent.putExtra("dato03", d3)
            intent.putExtra("dato04", d4)
            intent.putExtra("dato05", d5)
            intent.putExtra("dato06", d6)

            startActivity(intent)
            //println("Aqui llegamos")
            //println(txtnombres.id.toString())
        }

    }
}