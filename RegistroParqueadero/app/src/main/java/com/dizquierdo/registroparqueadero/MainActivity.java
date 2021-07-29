package com.dizquierdo.registroparqueadero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.Calendar;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    int id=1;
    String placa;
    String buscarPlaca;
    String hora;
    int ganancia=0;
    int compra;
    int pagoParqueo;
    boolean estado;
    EditText edtPlaca, edtCompra,edtPlacaSalida;
    Button btnRegistrar,btnSalida,btnInforme;
    ListView listResultado;
    RegistroAdapter myAdapter;
    ArrayList <Vehiculo> vehiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPlaca = findViewById(R.id.edtPlaca);
        edtPlacaSalida=findViewById(R.id.edtPlacaSalida);
        edtCompra = findViewById(R.id.edtCompra);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnSalida = findViewById(R.id.btnSalida);
        btnInforme = findViewById(R.id.btnInforme);
        listResultado = findViewById(R.id.listResultado);

        vehiculo = new ArrayList<>();
        myAdapter = new RegistroAdapter(this,vehiculo);
        listResultado.setAdapter(myAdapter);


    }

    public void guardar(View v){
        int Nplaca=edtPlaca.getText().toString().length();
        placa=edtPlaca.getText().toString().toUpperCase();
        if(Nplaca==7){
            vehiculo.add(new Vehiculo(id,placa,marcarHora(),"00:00",0,true));
            Toast mensajePlacaGuardada=Toast.makeText(getApplicationContext(), "Placa guardada", Toast.LENGTH_SHORT);
            mensajePlacaGuardada.show();
            id++;

        }else{
            Toast placaInvalida =
                    Toast.makeText(getApplicationContext(),
                            "Formato de placa invalido 'AAA-000'", Toast.LENGTH_SHORT);

            placaInvalida.show();
        }
    }

    public void Salida(View v){
        buscarPlaca=edtPlacaSalida.getText().toString().toUpperCase();
        if(edtCompra.getText().toString().isEmpty() || edtPlacaSalida.getText().toString().isEmpty()){
            Toast placaInvalida =
                    Toast.makeText(getApplicationContext(),
                            "LOS CAMPOS NO PUEDEN ESTAR VACIOS", Toast.LENGTH_SHORT);

            placaInvalida.show();
        }else{
            compra=Integer.parseInt(edtCompra.getText().toString());
            if(compra<10000){
                pagoParqueo=5000;
            }else{
                pagoParqueo=10000;
            }
        }

            for (int i=0; i <vehiculo.size();i++){
                if(vehiculo.get(i).getPlaca().equalsIgnoreCase(buscarPlaca)){
                    if(vehiculo.get(i).getEstado()){
                        vehiculo.get(i).setHoraSalida(marcarHora());
                        vehiculo.get(i).setEstado(false);
                        vehiculo.get(i).setPagoParqueo(pagoParqueo);
                        ganancia+=pagoParqueo;
                        Toast mensajeSalida =
                                Toast.makeText(getApplicationContext(),
                                        "Salida del vehiculo registrada", Toast.LENGTH_SHORT);
                        mensajeSalida.show();

                    }else{
                        Toast mensajeSalida =
                                Toast.makeText(getApplicationContext(),
                                        "Este vehiculo ya no esta en el parqueadero", Toast.LENGTH_SHORT);
                        mensajeSalida.show();

                    }

                }else{
                    Toast mensajeSalida =
                            Toast.makeText(getApplicationContext(),
                                    "Placa no encontrada", Toast.LENGTH_SHORT);
                    mensajeSalida.show();
                }
            }
        }

    public String marcarHora(){
        hora=Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+
                Calendar.getInstance().get(Calendar.MINUTE);
        return hora;
    }
    public void verInforme(View v){
        Intent i= new Intent(MainActivity.this,mainRegistros.class);
        i.putExtra("registro",vehiculo);
        i.putExtra("dinero",ganancia);
        startActivity(i);
    }


}