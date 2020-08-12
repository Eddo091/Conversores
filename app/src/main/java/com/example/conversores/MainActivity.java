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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Conversor ObjConversor  = new Conversor();

Spinner sptipo;
Spinner spDe;
Spinner spA;
EditText n1;
TextView lblRes;
Button BtnConv;

    private Object EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //Definir
        n1 = (EditText) findViewById( R.id.num1 );
        lblRes = (TextView) findViewById( R.id.lblRespuesta );
        sptipo = (Spinner) findViewById( R.id.cboTipo );
        spA = (Spinner) findViewById( R.id.cboA );
        spDe = (Spinner) findViewById( R.id.cboDe );
        BtnConv = (Button) findViewById( R.id.BtnConvertir );
        ArrayAdapter<String> Tip;
        ArrayAdapter<String> de;
        ArrayAdapter<String> a;
        String Tipo= String.valueOf( ObjConversor.Tipo );
        String De= String.valueOf( ObjConversor.Conversor );
        String A= String.valueOf( ObjConversor.Conversor );
        sptipo.setOnItemClickListener( (AdapterView.OnItemClickListener) this );
        spA.setOnItemClickListener( (AdapterView.OnItemClickListener) this );
        spDe.setOnItemClickListener( (AdapterView.OnItemClickListener) this );
        Tip= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Collections.singletonList( Tipo ) );
        de= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Collections.singletonList( De ) );
        a= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Collections.singletonList( A) );

        sptipo.setAdapter( Tip );
        spDe.setAdapter(de );
        spA.setAdapter( a );


    }


    @Override
    public void onItemSelected(AdapterView<?> a, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
