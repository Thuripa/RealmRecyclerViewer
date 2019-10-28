package com.example.fueldashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class FuelForm extends AppCompatActivity {

    private ArrayList db;
    private TextView tvID;
    private EditText etPosto;
    private EditText etLitros;
    private EditText etValor;
    private EditText etKm;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_form);

        Log.d("ALCM", "Actvity Instanciada");
        // Atribui o View pro objeto
        tvID = findViewById(R.id.tvID);
        etPosto = findViewById(R.id.etPosto);
        etLitros = findViewById(R.id.etLitros);
        etValor = findViewById(R.id.etValor);
        etKm = findViewById(R.id.etKm);

        Intent i = getIntent();
        db = i.getParcelableArrayListExtra("db");
        Log.d("ALCM", "DB pego dos Extras");


        /*if(db != null) {
            tvID.setText("99");
        } else {
            tvID.setText("0");
        }
        Log.d("ALCM", "ID's Setados");*/

        btnAdicionar = findViewById(R.id.button);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abastecimento abastecimento = new Abastecimento();

                CharSequence id = tvID.getText();


                //converte o texto do objeto em um inteiro
                int intID;
                intID = Integer.valueOf(id.toString());
                abastecimento.setId(intID);

                //seta posto
                abastecimento.setPosto(String.valueOf(etPosto.getText()));

                //seta litros
                Editable litros;
                litros = etLitros.getText();
                float litrosf = Float.valueOf(litros.toString());
                abastecimento.setLitros(litrosf);

                //seta Valor
                abastecimento.setValor(Float.valueOf(etValor.getText().toString()));

                //seta KM's
                abastecimento.setKm(Integer.valueOf(etKm.getText().toString()));



            }



        });



        // CONTINUAÇÂO ON CREATE...




    }

    public void adicionar(Abastecimento a){

        db.add(a);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putParcelableArrayListExtra("db",db);
    }
}
