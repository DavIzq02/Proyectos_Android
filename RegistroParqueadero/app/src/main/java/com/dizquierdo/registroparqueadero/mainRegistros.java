package com.dizquierdo.registroparqueadero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.widget.*;

public class mainRegistros extends AppCompatActivity {
    ListView listInforme;
    Button btnRegresar;
    TextView txtTotal;
    Bundle bundle;
    ArrayList<Vehiculo> informeParqueadero;
    RegistroAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_registros);
        bundle = getIntent().getExtras();
        informeParqueadero=(ArrayList<Vehiculo>)bundle.getSerializable("registro");
        myAdapter= new RegistroAdapter(this,informeParqueadero);
        int ganancia= bundle.getInt("dinero");
        listInforme = findViewById(R.id.listInforme);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtTotal = findViewById(R.id.txtTotal);
        listInforme.setAdapter(myAdapter);
        txtTotal.setText("EL TOTAL DE GANANCIA ES DE: "+ganancia);

    }
    public void CerrarActividad(View v){
        finish();
    }

}