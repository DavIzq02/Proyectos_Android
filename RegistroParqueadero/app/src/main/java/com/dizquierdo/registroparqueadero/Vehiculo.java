package com.dizquierdo.registroparqueadero;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private int id;
    private String placa;
    private String horaEntrada;
    private String horaSalida;
    private int pagoParqueo;
    private boolean estado;

    public Vehiculo(int id, String placa, String horaEntrada, String horaSalida, int pagoParqueo, boolean estado) {
        this.id = id;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.pagoParqueo = pagoParqueo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }
    public String getPlaca() {
        return placa;
    }
    public String getHoraEntrada() { return horaEntrada; }
    public String getHoraSalida() {
        return horaSalida;
    }
    public boolean getEstado() {
        return estado;
    }
    public int getPagoParqueo() {
        return pagoParqueo;
    }

    public void setPagoParqueo(int pagoParqueo) {
        this.pagoParqueo=pagoParqueo;
    }
    public void setEstado(boolean estado) {
        this.estado=estado;
    }
    public void setHoraSalida(String HoraSalida) {
        this.horaSalida=HoraSalida;
    }
}
