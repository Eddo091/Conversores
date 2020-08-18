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

import org.w3c.dom.Text;

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
    }; //Save

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //Definir
        final Spinner spDe=(Spinner)findViewById( R.id.cboDe );
        final Spinner spA=(Spinner)findViewById( R.id.cboA );
        final EditText n1=(EditText)findViewById( R.id.num1 );
        final TextView lblresp=(TextView)findViewById( R.id.lblRespuesta );
        final Button Convertir=(Button)findViewById( R.id.BtnConvertir );
        //Spinner
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

            //Onclick_codigo
            public  void ProcesarBtncon (View c)
            {
                validar();

            }
            //Validación de texto
            public boolean validar(){
            boolean retorno=true;
            String num=n1.getText().toString();

            if (num.isEmpty())
            {
                n1.setError( "Ingrese numero valido" );
                retorno=false;
            }
            return  retorno;

            }

            //Valores de conversor
            

        } );
    }
//Onclick_Accion
    public void ProcesarBtnConvertir(View view) {
       ProcesarBtnConvertir( view );
    }
}
