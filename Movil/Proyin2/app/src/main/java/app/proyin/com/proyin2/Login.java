package app.proyin.com.proyin2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.proyin.adaptadores.IDTO;
import com.proyin.clasesbases.TipoAccion;
import com.proyin.clasesbases.TipoAlerta;
import com.proyin.clasesbases.TipoError;
import com.proyin.clasesbases.WebServiceConection;
import com.proyin.entidades.Empleado;
import com.proyin.parceables.PEmpleado;


import alerts.AlertComponent;


public class Login extends Activity {

    private Button btnIniciarSesion;
    private EditText txtUsuario;
    private EditText txtPassword;
    private ProgressDialog dialog;
    private String usuario, clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        configuracionLayout();

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = txtUsuario.getText().toString();
                clave = txtPassword.getText().toString();
                AsyncCallWS task = new AsyncCallWS();
                task.execute();
            }
        });
    }

    private void iniciarComponentes() {
        btnIniciarSesion = (Button)findViewById(R.id.btnIniciarSesion);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    private void configuracionLayout(){
        // ocultar la barra de notificaciones de la app
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                                 ,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //ocultar barra de acciones
        //this.getActionBar().hide();

    }

    private class AsyncCallWS extends AsyncTask<IDTO, Void, IDTO> {

        @Override
        protected void onPreExecute(){
            dialog = new ProgressDialog(Login.this);
            dialog.setProgressStyle(dialog.STYLE_SPINNER);
            dialog.setMessage("Cargando...");
            dialog.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected IDTO doInBackground(IDTO... params) {
            WebServiceConection wsConnection = new WebServiceConection(TipoAccion.verificarAccesoMovil.toString());
            Empleado objEmpleado = (Empleado) wsConnection.invokeLogin(usuario, clave);
            return objEmpleado;
        }

        @Override
        protected void onPostExecute(IDTO result) {
                dialog.dismiss();
                Empleado objEmpleado = (Empleado) result;
                AlertDialog alertDialog;
                if(objEmpleado == null) {
                    alertDialog = AlertComponent.getInstance().builAlert(Login.this, TipoAlerta.LOGIN_ERROR.toString());
                    alertDialog.show();
                }
                else if(!objEmpleado.getIdPersona().equals(TipoError.EXCEPCION.toString())) {
                    PEmpleado objPEmpleado = new PEmpleado(objEmpleado);
                    Intent intent = new Intent(Login.this, Principal.class);
                    intent.putExtra("empleado", objPEmpleado);
                    startActivity(intent);
                } else {
                    alertDialog = AlertComponent.getInstance().builAlert(Login.this, TipoAlerta.EXCEPCION.toString());
                    alertDialog.show();
            }
        }
    }
}
