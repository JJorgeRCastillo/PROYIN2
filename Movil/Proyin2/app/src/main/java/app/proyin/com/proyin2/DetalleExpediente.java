package app.proyin.com.proyin2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.proyin.adaptadores.IDTO;
import com.proyin.entidades.DatosCredito;
import com.proyin.eventos.ListenerButton;
import com.proyin.parceables.PDatosCredito;

public class DetalleExpediente extends Activity {

    // private InputMethodManager inputMethodManager;
    private TextView txtSocio, txtExpediente;
    private EditText txtMonto, txtPlazo, txtTasa, txtFPVencimiento;
    private Button btnAprobar;
    private PDatosCredito objPDatosCredito;
    private final int DATE_PICKER_ID = 1111;
    private String[] fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_expediente);
        iniciarComponentes();
        fecha = iniciarParametros();
        txtFPVencimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showDialog(DATE_PICKER_ID);
            }
        });
        btnAprobar.setOnClickListener(new ListenerButton(objPDatosCredito, DetalleExpediente.this));
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:
                int mes = Integer.parseInt(fecha[1])-1;
                return new DatePickerDialog(this, dateSetListener, Integer.parseInt(fecha[0]), mes, Integer.parseInt(fecha[2]));
        }
        return  null;
    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int dia, mes, anio;
            dia = dayOfMonth;
            mes = ((monthOfYear+1)>12?monthOfYear:(monthOfYear+1));
            anio = year;

            String sdia, smes;

            sdia = (dia < 10)?("0"+dia):(dia+"");
            smes = (mes < 10)?("0"+mes):(mes+"");

            txtFPVencimiento.setText(sdia + "/" + smes + "/" + anio);
        }
    };

    private String[] iniciarParametros() {
        this.objPDatosCredito = getIntent().getParcelableExtra("datoscredito");
        return cargarDatos(objPDatosCredito.getObjDatosCredito());
    }

    private void iniciarComponentes() {
        txtSocio = (TextView) findViewById(R.id.txtSocioExpediente);
        txtExpediente = (TextView) findViewById(R.id.txtExpedienteDet);
        txtMonto = (EditText) findViewById(R.id.txtMontoExpediente);
        txtPlazo = (EditText) findViewById(R.id.txtPlazoExpediente);
        txtTasa = (EditText) findViewById(R.id.txtTasaExpediente);
        txtFPVencimiento = (EditText) findViewById(R.id.txtFechaPVencimiento);
        txtMonto.setFocusable(true);
        btnAprobar = (Button) findViewById(R.id.btnAprobarExpediente);
        txtFPVencimiento.setShowSoftInputOnFocus(false);

    }

    private String[] cargarDatos(IDTO idto){
        DatosCredito objDatosCredito = (DatosCredito) idto;
        txtSocio.setText(objDatosCredito.getObjSocio().getIdSocio() + " " + objDatosCredito.getObjSocio().getNombreSocio());
        String[] values = objDatosCredito.getObjDocumentoGenerado().getEstadoDocumento().split("-");
        String moneda = (objDatosCredito.getObjDocumentoGenerado().getTipoMoneda().equals("1"))? "SOLES": "DOLARES";
        txtExpediente.setText(values[0] + "-" +
                objDatosCredito.getObjDocumentoGenerado().getObjDocumento().getIdDocumento() + "-" +
                objDatosCredito.getObjDocumentoGenerado().getNroDocumento() + "-" +
                moneda);
        txtMonto.setText(String.format("%.2f",objDatosCredito.getMontoSolicitado()));
        txtPlazo.setText(objDatosCredito.getPlazoSolicitado()+"");
        txtTasa.setText(objDatosCredito.getIcSolicitado()+"");
        String[] fecha = objDatosCredito.getFechaVencimientoPimCouta().split("-");
        txtFPVencimiento.setText(fecha[2] + "/" + fecha[1] + "/" + fecha[0]);
        return fecha;
    }
}
