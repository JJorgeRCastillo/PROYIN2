package app.proyin.com.proyin2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import com.proyin.adaptadores.AdapterItemExpediente;
import com.proyin.clasesbases.TipoAccion;
import com.proyin.clasesbases.TipoAlerta;
import com.proyin.clasesbases.TipoError;
import com.proyin.clasesbases.WebServiceConection;
import com.proyin.entidades.DatosCredito;
import com.proyin.eventos.ListenerListView;

import java.util.List;

import alerts.AlertComponent;

public class ListarExpedientes extends Activity {

    private ListView lstView;
    private AdapterItemExpediente adapterItemExpediente;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_expedientes);
        iniciarComponentes();
        AsyncCallWS task = new AsyncCallWS();
        task.execute();
        iniciarEventos();
    }

    private void iniciarComponentes() {
        lstView = (ListView)findViewById(R.id.lstExpedientesPendientes);
    }

    private void iniciarEventos() {
        lstView.setOnItemClickListener(new ListenerListView(ListarExpedientes.this));
    }

    private class AsyncCallWS extends AsyncTask<Void, Void, List<DatosCredito> > {
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(ListarExpedientes.this);
            dialog.setProgressStyle(dialog.STYLE_SPINNER);
            dialog.setMessage("Cargando...");
            dialog.show();
        }

        @Override
        protected List<DatosCredito> doInBackground(Void... params) {
            WebServiceConection wsConnection = new WebServiceConection(TipoAccion.listarExpedientesPendientes.toString());
            List<DatosCredito> lstDatosCredito = wsConnection.invokeExpedientesPendientes("0007","01","01","ferlyn","01");
            return lstDatosCredito;
        }

        @Override
        protected void onPostExecute(List<DatosCredito> lstDatosCredito) {
            dialog.dismiss();
            AlertDialog alertDialog;
            if(lstDatosCredito.get(0).getComentarios().equals(TipoError.EXCEPCION.toString())) {
                alertDialog = AlertComponent.getInstance().builAlert(ListarExpedientes.this, TipoAlerta.EXCEPCION.toString());
                alertDialog.show();
            } else{
                adapterItemExpediente = new AdapterItemExpediente(getApplicationContext(), lstDatosCredito);
                lstView.setAdapter(adapterItemExpediente);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }



}
