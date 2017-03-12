package com.jccl.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class contacto extends AppCompatActivity {

    private EditText etNombre;
    private EditText etCorreo;
    private EditText etMensaje;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etCorreo = (EditText) findViewById(R.id.etEmail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Enviar();
            Limpiar();
        }
    });
}

    private void Enviar(){
        String email = etCorreo.getText().toString().trim();
        String mensaje = etMensaje.getText().toString().trim();
        String asunto = "Mensaje de - " + etNombre.getText().toString().trim();

        EnviarCorreo e = new EnviarCorreo(this,email,asunto,mensaje);
        e.execute();
    }

    private void Limpiar(){
        etCorreo.setText("");
        etNombre.setText("");
        etMensaje.setText("");
    }
}
