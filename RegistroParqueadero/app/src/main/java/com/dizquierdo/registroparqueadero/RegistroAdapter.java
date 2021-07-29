package com.dizquierdo.registroparqueadero;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.content.Context;
import java.util.ArrayList;

public class RegistroAdapter extends BaseAdapter {
     Activity activity;
     ArrayList<Vehiculo> vehiculo;
     TextView txtPlaca, txtHoraEntrada,txtHoraSalida,txtPagoParqueo,txtEstado;

    public RegistroAdapter(Activity activity, ArrayList<Vehiculo> vehiculo) {
        this.activity = activity;
        this.vehiculo = vehiculo;
    }

    @Override
    public int getCount() {
        return vehiculo.size();
    }

    @Override
    public Object getItem(int position) {
        return vehiculo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return vehiculo.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=inflater.inflate(R.layout.registro,null);

        txtPlaca= v.findViewById(R.id.txtPlaca);
        txtHoraEntrada  = v.findViewById(R.id.txtHoraEntrada);
        txtHoraSalida   = v.findViewById(R.id.txtHoraSalida);
        txtPagoParqueo  = v.findViewById(R.id.txtPagoParqueo);
        txtEstado       = v.findViewById(R.id.txtEstado);
        Vehiculo info = vehiculo.get(position);
        txtPlaca.setText(info.getPlaca());
        txtHoraEntrada.setText(info.getHoraEntrada());
        txtHoraSalida.setText(info.getHoraSalida());
        txtPagoParqueo.setText(Integer.toString((info.getPagoParqueo())));

        if(info.getEstado()){
            txtEstado.setText("EN EL PARQUEADERO");
        }else {
            txtEstado.setText("VEHICULO RETIRADO");
        }
        return v;
    }
}
