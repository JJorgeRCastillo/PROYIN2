package com.proyin.eventos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;

import com.proyin.adaptadores.IDTO;
import com.proyin.clasesbases.TipoAccion;
import com.proyin.clasesbases.TipoAlerta;
import com.proyin.clasesbases.WebServiceConection;
import com.proyin.parceables.PDatosCredito;

import alerts.AlertComponent;
import app.proyin.com.proyin2.ListarExpedientes;
import app.proyin.com.proyin2.R;

/**
 * Created by JorgePC on 01/07/16.
 */
public class ListenerButton implements View.OnClickListener {

    private ProgressDialog dialog;
    private IDTO idto;
    private Activity activity;

    public ListenerButton(IDTO idto, Activity activity) {
        this.idto = idto;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if (this.idto instanceof PDatosCredito) {
            PDatosCredito objPDatosCredito = (PDatosCredito)idto;
            EditText txtMonto = (EditText)this.activity.findViewById(R.id.txtMontoExpediente);
            EditText txtPlazo = (EditText)this.activity.findViewById(R.id.txtPlazoExpediente);
            EditText txtTasa = (EditText)this.activity.findViewById(R.id.txtTasaExpediente);
            EditText txtPVFecha = (EditText)this.activity.findViewById(R.id.txtFechaPVencimiento);

            float montoAprobado = Float.parseFloat(txtMonto.getText().toString());
            float tasaAprobada = Float.parseFloat(txtTasa.getText().toString());

            String monto = String.format("%.2f",montoAprobado);
            String tasa = String.format("%.1f", tasaAprobada);
            int plazo = Integer.parseInt(txtPlazo.getText().toString());
            String fecha = txtPVFecha.getText().toString();

            objPDatosCredito.getObjDatosCredito().setMontoAprobado(Float.parseFloat(monto));
            objPDatosCredito.getObjDatosCredito().setPlazoAprobado(plazo);
            objPDatosCredito.getObjDatosCredito().setIcAprobado(Float.parseFloat(tasa));
            objPDatosCredito.getObjDatosCredito().setFechaVencimientoPimCouta(fecha);

            // LLamamos al evento del WebService por medio de un AsyncTask
            AsyncCallWS task = new AsyncCallWS();
            task.execute();

        }
    }

    private class AsyncCallWS extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(activity);
            dialog.setProgressStyle(dialog.STYLE_SPINNER);
            dialog.setMessage("Cargando...");
            dialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            WebServiceConection wsConnection = new WebServiceConection(TipoAccion.aprobarExpediente.toString());
            boolean respuesta = wsConnection.invokeAprobarExpedienteCredito(((PDatosCredito)idto).getObjDatosCredito());
            return respuesta;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            dialog.dismiss();
            AlertDialog alertDialog;
            if (aBoolean == true) {
                alertDialog = AlertComponent.getInstance().builAlert(activity, TipoAlerta.SUCCESS.toString());
                alertDialog.show();
               Intent intent = new Intent(activity, ListarExpedientes.class);
               activity.startActivity(intent);
            } else {
                alertDialog = AlertComponent.getInstance().builAlert(activity, TipoAlerta.ERROR.toString());
                alertDialog.show();
            }
        }
    }

    private void enableControls() {

    }
}
