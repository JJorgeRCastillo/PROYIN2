package com.proyin.parceables;

import android.os.Parcel;
import android.os.Parcelable;

import com.proyin.adaptadores.IDTO;
import com.proyin.entidades.DatosCredito;

/**
 * Created by JorgePC on 29/06/16.
 */
public class PDatosCredito implements Parcelable, IDTO {

    private DatosCredito objDatosCredito;

     public static final Parcelable.Creator<PDatosCredito> CREATOR = new Creator<PDatosCredito>() {

         @Override
         public PDatosCredito createFromParcel(Parcel source) {
             return new PDatosCredito(source);
         }

         @Override
         public PDatosCredito[] newArray(int size) {
             return new PDatosCredito[size];
         }
     };

    public PDatosCredito(DatosCredito objDatosCredito) {
        this.objDatosCredito = objDatosCredito;
    }

    public PDatosCredito(Parcel parcel) {
        this.objDatosCredito = new DatosCredito();
        readFromParcel(parcel);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getFechaDocumento());
        dest.writeString(getObjDatosCredito().getObjSocio().getIdSocio());
        dest.writeString(getObjDatosCredito().getObjSocio().getNombreSocio());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getNroDocumento());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getTipoMoneda());
        dest.writeString(getObjDatosCredito().getTipoCredito());
        dest.writeFloat(getObjDatosCredito().getMontoSolicitado());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getObjPersona().getIdPersona());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getTipoMoneda());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getObjDocumento().getIdDocumento());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getObjOfcina().getIdOficina());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getEstadoDocumento());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getObjOfcina().getNombreAbreviado());
        dest.writeString(getObjDatosCredito().getNivel1());
        dest.writeString(getObjDatosCredito().getNivel2());
        dest.writeString(getObjDatosCredito().getNivel3());
        dest.writeString(getObjDatosCredito().getObjProductoCrediticio().getIdProductoCrediticio());
        dest.writeInt(getObjDatosCredito().getPlazoSolicitado());
        dest.writeFloat(getObjDatosCredito().getIcSolicitado());
        dest.writeString(getObjDatosCredito().getObjSeguimiento().getNivel());
        dest.writeInt(getObjDatosCredito().getObjSeguimiento().getMaximoNivel());
        dest.writeString(getObjDatosCredito().getFechaProceso());
        dest.writeString(getObjDatosCredito().getHoraProceso());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getObjUsuario().getIdUsuario());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getFechaCambioEstado());
        dest.writeString(getObjDatosCredito().getObjDocumentoGenerado().getDocumentoAnterior());
        dest.writeString(getObjDatosCredito().getFechaVencimientoPimCouta());


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.getObjDatosCredito().getObjDocumentoGenerado().setFechaDocumento(parcel.readString());
        this.getObjDatosCredito().getObjSocio().setIdSocio(parcel.readString());
        this.getObjDatosCredito().getObjSocio().setNombreSocio(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().setNroDocumento(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().setTipoMoneda(parcel.readString());
        this.getObjDatosCredito().setTipoCredito(parcel.readString());
        this.getObjDatosCredito().setMontoSolicitado(parcel.readFloat());
        this.getObjDatosCredito().getObjDocumentoGenerado().getObjPersona().setIdPersona(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().setTipoMoneda(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().getObjDocumento().setIdDocumento(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().getObjOfcina().setIdOficina(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().setEstadoDocumento(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().getObjOfcina().setNombreAbreviado(parcel.readString());
        this.getObjDatosCredito().setNivel1(parcel.readString());
        this.getObjDatosCredito().setNivel2(parcel.readString());
        this.getObjDatosCredito().setNivel3(parcel.readString());
        this.getObjDatosCredito().getObjProductoCrediticio().setIdProductoCrediticio(parcel.readString());
        this.getObjDatosCredito().setPlazoSolicitado(parcel.readInt());
        this.getObjDatosCredito().setIcSolicitado(parcel.readFloat());
        this.getObjDatosCredito().getObjSeguimiento().setNivel(parcel.readString());
        this.getObjDatosCredito().getObjSeguimiento().setMaximoNivel(parcel.readInt());
        this.getObjDatosCredito().setFechaProceso(parcel.readString());
        this.getObjDatosCredito().setHoraProceso(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().getObjUsuario().setIdUsuario(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().setFechaCambioEstado(parcel.readString());
        this.getObjDatosCredito().getObjDocumentoGenerado().setDocumentoAnterior(parcel.readString());
        this.getObjDatosCredito().setFechaVencimientoPimCouta(parcel.readString());
    }

    public DatosCredito getObjDatosCredito() {
        return objDatosCredito;
    }

    public void setObjDatosCredito(DatosCredito objDatosCredito) {
        this.objDatosCredito = objDatosCredito;
    }

}
