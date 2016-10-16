package com.proyin.eventos;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.proyin.entidades.DatosCredito;
import com.proyin.parceables.PDatosCredito;

import app.proyin.com.proyin2.DetalleExpediente;

/**
 * Created by JorgePC on 26/06/16.
 */
public class ListenerListView implements AdapterView.OnItemClickListener{

    private Activity activity;

    public ListenerListView(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object o = parent.getItemAtPosition(position);
        if (o instanceof DatosCredito){
            PDatosCredito objPDatosCredito = new PDatosCredito((DatosCredito)o);
            Intent intent = new Intent(this.activity, DetalleExpediente.class);
            intent.putExtra("datoscredito", objPDatosCredito);
            this.activity.startActivity(intent);
        }
    }

}
