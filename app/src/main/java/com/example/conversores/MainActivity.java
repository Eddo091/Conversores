package com.example.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String[][] mon = {
            {"Dolar","Euro","Colon SV", "Colon CR","Lempira","Bitcoin","Won Sur Coreano","Won Nor Coreano","Peso ARG","Peso MXN"},//Moneda
            {"Gramo","Kilogramo","Miligramo", "Microgramo", "Tonelada Larga","Tonelada corta","Libra","Onza","Tonelada","Stone"},//Masa
            {"Litro","Mililitro","Galón imperial", "Cuarto imperial","Pinta imperial", "Taza imperial","Cucharada imperial","Cucharadita imperial","Pie cúbico","Pulgada cúbica"},//Volumen
            {"Metro","CM","Milimetro", "Micrómetro","Nanómetro", "Milla","Yarda","Pie","Pulgada","Milla Náutica"},//Longitud
            {"Bit","Byte","KB", "MB","GB", "TB","PB","EB","ZB","YB"},//Almacenamiento
            {"Sg","Nanosg","Minuto", "Hora","Día", "Semana","Mes","Año Natural","Década","Siglo"},//Tiempo
            {"Bit por sg","Kbit por sg","KB por sg", "MGBit por sg","MG por sg", "MiBit por sg","GBit por sg","GB por sg","Gibit por sg","TB por sg"},//Transferencia de datos
    };


EditText n1;
TextView lblRes;
Button BtnConv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //Definir
        final Spinner spDe=(Spinner)findViewById( R.id.cboDe );
        final Spinner spA=(Spinner)findViewById( R.id.cboA );

        Spinner sptipo =(Spinner)findViewById( R.id.cboTipo );
        sptipo.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            spDe.setAdapter( new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, mon[position]  ) );
            spA.setAdapter( new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, mon[position]  ) );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );
    }
}
