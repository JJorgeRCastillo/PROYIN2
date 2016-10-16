package com.proyin.parceables;

import android.os.Parcel;
import android.os.Parcelable;

import com.proyin.adaptadores.IDTO;
import com.proyin.entidades.Empleado;
import com.proyin.entidades.Usuario;

/**
 * Created by JorgePC on 03/07/16.
 */
public class PEmpleado implements Parcelable, IDTO {

    private Empleado objEmpleado;

    public static final Parcelable.Creator<PEmpleado> CREATOR = new Creator<PEmpleado>() {
        @Override
        public PEmpleado createFromParcel(Parcel source) {
            return new PEmpleado(source);
        }

        @Override
        public PEmpleado[] newArray(int size) {
            return new PEmpleado[size];
        }
    };

    public PEmpleado(Empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }

    public PEmpleado(Parcel parcel) {
        this.objEmpleado = new Empleado();
        Usuario objUsuario = new Usuario();
        this.objEmpleado.setObjUsuario(objUsuario);
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel) {
        this.objEmpleado.setIdPersona(parcel.readString());
        this.objEmpleado.getObjUsuario().setIdUsuario(parcel.readString());
        this.objEmpleado.getObjOficina().setIdOficina(parcel.readString());
        this.objEmpleado.getObjOficina().setNombre(parcel.readString());
        this.objEmpleado.getObjPersonaNatural().setIdPersona(parcel.readString());
        this.objEmpleado.getObjPersonaNatural().setNombres(parcel.readString());
        this.objEmpleado.getObjPersonaNatural().setApPaterno(parcel.readString());
        this.objEmpleado.getObjPersonaNatural().setApMaterno(parcel.readString());
        this.objEmpleado.getObjPersonaNatural().setNroDocumento(parcel.readString());
        this.objEmpleado.getObjPuesto().setIdPuesto(parcel.readString());
        this.objEmpleado.getObjPuesto().setNombre(parcel.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getObjEmpleado().getIdPersona());
        dest.writeString(getObjEmpleado().getObjUsuario().getIdUsuario());
        dest.writeString(getObjEmpleado().getObjOficina().getIdOficina());
        dest.writeString(getObjEmpleado().getObjOficina().getNombre());
        dest.writeString(getObjEmpleado().getObjPersonaNatural().getIdPersona());
        dest.writeString(getObjEmpleado().getObjPersonaNatural().getNombres());
        dest.writeString(getObjEmpleado().getObjPersonaNatural().getApPaterno());
        dest.writeString(getObjEmpleado().getObjPersonaNatural().getApMaterno());
        dest.writeString(getObjEmpleado().getObjPersonaNatural().getNroDocumento());
        dest.writeString(getObjEmpleado().getObjPuesto().getIdPuesto());
        dest.writeString(getObjEmpleado().getObjPuesto().getNombre());
    }

    public Empleado getObjEmpleado() {
        return objEmpleado;
    }

    public void setObjEmpleado(Empleado objEmpleado) {
        this.objEmpleado = objEmpleado;
    }
}
