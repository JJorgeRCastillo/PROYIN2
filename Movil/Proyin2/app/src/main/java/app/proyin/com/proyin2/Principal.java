package app.proyin.com.proyin2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyin.parceables.PEmpleado;


public class Principal extends Activity {

    private PEmpleado objPEmpleado;
    private Button btnExpedientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        iniciarComponentes();
        iniciarParametros();

        btnExpedientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, ListarExpedientes.class);
                startActivity(intent);
            }
        });

    }

    private void iniciarComponentes() {
        btnExpedientes = (Button) findViewById(R.id.btnListarExpedientes);
    }

    private void iniciarParametros() {
        this.objPEmpleado = getIntent().getParcelableExtra("empleado");
    }
}
