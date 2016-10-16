package alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.proyin.clasesbases.TipoAlerta;

import app.proyin.com.proyin2.R;

/**
 * Created by JorgePC on 22/06/16.
 */
public class AlertComponent {

    private static AlertComponent _instance;

    private AlertComponent() { }

    public static AlertComponent getInstance() {
        if (_instance == null) _instance = new AlertComponent();
        return _instance;
    }

    /**
     *
     * @param activity Actividad donde se creara la alerta
     * @param tipo Puede ser [ERROR, WARNING, SUCCESS]
     * @return Retorna un objeto AlertDialog
     */
    public AlertDialog builAlert(Activity activity, String tipo) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (tipo.equals(TipoAlerta.LOGIN_ERROR.toString())) {
            builder.setTitle(R.string.alert_title_credenciales)
                   .setMessage(R.string.alert_message_login_error_credenciales);

        }
        else if (tipo.equals(TipoAlerta.EXCEPCION.toString())){
            builder.setTitle("Excepcion")
                   .setMessage("Ocurrió una excepción.");
        }
        else  if(tipo.equals(TipoAlerta.ERROR.toString())) {
            builder.setTitle("Error")
                   .setMessage("Error al procesar solicitud.");
        }
        else {
            builder.setTitle("Correcto")
                   .setMessage("Procesamiento correcto.");
        }
        builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

}
