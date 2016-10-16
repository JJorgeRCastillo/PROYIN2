package com.proyin.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.proyin.entidades.DatosCredito;

import java.util.List;

import app.proyin.com.proyin2.R;

/**
 * Created by JorgePC on 25/06/16.
 */
public class AdapterItemExpediente extends ArrayAdapter<DatosCredito> implements IDTO {

    private Context context;
    private List<DatosCredito> lstDatosCreditos;

    public AdapterItemExpediente(Context context, List<DatosCredito> lstDatosCreditos) {
        super(context, R.layout.listar_expedientes_items, lstDatosCreditos);
        this.context = context;
        this.lstDatosCreditos = lstDatosCreditos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.listar_expedientes_items, parent, false);

        TextView nombreSocio = (TextView) view.findViewById(R.id.txtNombreSocio);
        TextView montoSolicitado = (TextView) view.findViewById(R.id.txtMontoSolicitado);
        TextView fechaProceso = (TextView) view.findViewById(R.id.txtFechaExpediente);
        TextView nroExpediente = (TextView) view.findViewById(R.id.txtNroExpediente);

        DatosCredito objDatosCredito = lstDatosCreditos.get(position);

        nombreSocio.setText(objDatosCredito.getObjSocio().getNombreSocio());
        nroExpediente.setText(objDatosCredito.getObjDocumentoGenerado().getNroDocumento());
        String moneda = (objDatosCredito.getObjDocumentoGenerado().getTipoMoneda().equals("1"))? "S/. ": "";

        montoSolicitado.setText(moneda + String.format("%.2f",objDatosCredito.getMontoSolicitado()));
        fechaProceso.setText(objDatosCredito.getFechaProceso() + " " + objDatosCredito.getHoraProceso());

        return view;
    }

    @Override
    public DatosCredito getItem(int position) {
        return lstDatosCreditos.get(position);
    }

    @Override
    public int getCount() {
        return lstDatosCreditos.size();
    }

    @Override
    public long getItemId(int position) {
        return  position;
    }


}
