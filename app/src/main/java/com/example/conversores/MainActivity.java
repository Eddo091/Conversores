package com.example.conversores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[][] tipos = {
            {"Dolar","Euro","Colon SV", "Colon CR","Lempira","Bitcoin","Won Sur Coreano","Won Nor Coreano","Peso ARG","Peso MXN"},//Moneda
            {"Gramo","Kilogramo","Miligramo", "Microgramo", "Tonelada Larga","Tonelada corta","Libra","Onza","Tonelada","Stone"},//Masa
            {"Litro","Mililitro","Galón imperial", "Cuarto imperial","Pinta imperial", "Taza imperial","Cucharada imperial","Cucharadita imperial","Pie cúbico","Pulgada cúbica"},//Volumen
            {"Metro","CM","Milimetro", "Micrómetro","Nanómetro", "Milla","Yarda","Pie","Pulgada","Milla Náutica"},//Longitud
            {"Bit","Byte","KB", "MB","GB", "TB","PB","EB","ZB","YB"},//Almacenamiento
            {"Sg","Nanosg","Minuto", "Hora","Día", "Semana","Mes","Año Natural","Década","Siglo"},//Tiempo
            {"Bit por sg","Kbit por sg","KB por sg", "MGBit por sg","MG por sg", "MiBit por sg","GBit por sg","GB por sg","Gibit por sg","TB por sg"},//Transferencia de datos
    };
    double[][] valores={
            new double[]{1,0.84,8.75,594.93,24.65,0.000085,1180.54,900.045,73.48,22.02},//moneda
            new double[]{1,0.001,1000,1e+6,9.8421e-7,1.1023e-6,0.00220462,0.035274,1e-6,0.000157473},//Masa
            new double[]{1,1000,0.219969,0.879876,1.75975,3.51951,56.3121,168.936,0.0353147,61.0237},//Volumen
            new double[]{1,100,1000,1e+6,1e+9,0.000621371,1.09361,3.28084,39.3701,0.000539957},//Longitud
            new double[]{1,0.125,0.000125,1.25e-7,1.25e-10,1.25e-13,1.25e-16,1.25e-19,1.25e-22,1.25e-25},//Almacenamiento
            new double[]{1,1e+9,0.0166667,0.000277778,1.1574083333e-5,1.653440476142857e-6,3.80517391202858972e-7,3.170981735068493655e-8,3.171e-9,3.171e-10},//Tiempo
            new double[]{1,0.001,0.000125,1e-6,1.25e-7,9.5367e-7,1e-9,1.25e-10,9.3132e-10,1e-12}//Transferencia de datos

    };

    //Definir
    final Spinner spDe=(Spinner)findViewById( R.id.cboDe );
    final Spinner spA=(Spinner)findViewById( R.id.cboA );
    final EditText n1=(EditText)findViewById( R.id.num1 );
    final TextView lblresp=(TextView)findViewById( R.id.lblRespuesta );
    final Button Convertir=(Button)findViewById( R.id.BtnConvertir );
    final Spinner sptipo =(Spinner)findViewById( R.id.cboTipo );
    //Save

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        sptipo.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            spDe.setAdapter( new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, tipos[position]  ) );
            spA.setAdapter( new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, tipos[position]  ) );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        } );

    }



    //Validación de texto
    public boolean validar(){
        boolean retorno=true;
        EditText n1=(EditText)findViewById( R.id.num1 );
        String num=n1.getText().toString();

        if (num.isEmpty())
        {
            n1.setError( "Ingrese numero valido" );
            retorno=false;
        }
        return  retorno;

    }

//Onclick_Accion
    public void ProcesarBtnConvertir(View view) {
       ProcesarBtnConvertir( view );
        validar();

        int opcion = 0,de=0,a=0;
        double cantidad = 0,resp=0;
        de= spDe.getSelectedItemPosition();
        a=  spA.getSelectedItemPosition();
        switch (sptipo.getId()){

            case 0:
                resp= valores[0][a]/valores[0][de]*cantidad;
                break;
            case 1:
                resp= valores[1][a]/valores[1][de]*cantidad;
                break;
            case 2:
                resp= valores[2][a]/valores[2][de]*cantidad;
                break;
            case 3:
                resp= valores[3][a]/valores[3][de]*cantidad;
                break;
            case 4:
                resp= valores[4][a]/valores[4][de]*cantidad;
                break;
            case 5:
                resp= valores[5][a]/valores[5][de]*cantidad;
                break;
            case 6:
                resp= valores[6][a]/valores[6][de]*cantidad;
                break;
        }

        lblresp.setText( "Respuesta" + resp );

    }
}
