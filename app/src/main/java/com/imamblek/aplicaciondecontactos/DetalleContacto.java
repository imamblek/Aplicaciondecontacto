package com.imamblek.aplicaciondecontactos;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DetalleContacto extends AppCompatActivity {

    Button botonvolverPrincipal;
    TextView outnombre;
    TextView outfecha;
    TextView outtelefono;
    TextView outemail;
    TextView outdescripcion;

    Bundle mostrardatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        outnombre = (TextView)findViewById(R.id.tvnombre);
        outfecha = (TextView)findViewById(R.id.tvfecha);
        outtelefono = (TextView)findViewById(R.id.tvtelefono);
        outemail = (TextView)findViewById(R.id.tvemail);
        outdescripcion = (TextView)findViewById(R.id.tvdescripcion);



        botonvolverPrincipal = (Button) findViewById(R.id.botonEditarDatosUsuario);
        botonvolverPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent volverPrincipal = new Intent(DetalleContacto.this,MainActivity.class);
                volverPrincipal.putExtra("$nombre",outnombre.getText().toString());
                startActivity(volverPrincipal);
            }
        });

        Bundle mostrardatos = getIntent().getExtras();
        String nombre = mostrardatos.getString("$nombre");
        String fecha = mostrardatos.getString("$fecha");
        String telefono = mostrardatos.getString("$telefono");
        String email = mostrardatos.getString("$email");
        String descripcion = mostrardatos.getString("$descripcion");

        outnombre.setText(nombre);
        outfecha.setText(fecha);
        outtelefono.setText(telefono);
        outemail.setText(email);
        outdescripcion.setText(descripcion);
     }
}