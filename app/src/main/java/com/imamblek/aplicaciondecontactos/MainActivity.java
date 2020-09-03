package com.imamblek.aplicaciondecontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static com.imamblek.aplicaciondecontactos.DatePickerFragment.DATE_DIALOG;
import static com.imamblek.aplicaciondecontactos.DatePickerFragment.txtDate;


public class MainActivity extends AppCompatActivity {
    ///Declaracion de variables
    EditText etnombre;
    EditText etfechaNacimientoPicker;
    EditText ettelefono;
    EditText etemail;
    EditText etdescripcion;
    ArrayList<Info> detalles;

    private Button botonSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);

        etnombre = findViewById(R.id.etnombre);
        etfechaNacimientoPicker = findViewById(R.id.etfechaNacimientoPicker);
        ettelefono = findViewById(R.id.ettelefono);
        etemail = findViewById(R.id.etemail);
        etdescripcion = findViewById(R.id.etdescripcionContacto);
        //----------------------------------------------------------
        detalles = new ArrayList<Info>();
        detalles.add(new Info(etnombre + "", etfechaNacimientoPicker + "", ettelefono + "", etemail + "", etdescripcion + ""));

        //----------------------------------------------------------


        //----------------------------------------------------------

        botonSalvar = findViewById(R.id.botonSalvarDatosUsuario);
        botonSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent mostrarPantallaDetalles = new Intent(MainActivity.this, DetalleContacto.class);

                String nombre = etnombre.getText().toString();
                String fecha = etfechaNacimientoPicker.getText().toString();
                String telefono = ettelefono.getText().toString();
                String email = etemail.getText().toString();
                String detalles = etdescripcion.getText().toString();

                mostrarPantallaDetalles.putExtra("$nombre", nombre);
                mostrarPantallaDetalles.putExtra("$fecha", fecha);
                mostrarPantallaDetalles.putExtra("$telefono", telefono);
                mostrarPantallaDetalles.putExtra("$email", email);
                mostrarPantallaDetalles.putExtra("$descripcion", detalles);

                startActivity(mostrarPantallaDetalles);

            }
        });


        //----------------------------------------------------------DATE PICKER
        txtDate = findViewById(R.id.etfechaNacimientoPicker);
        txtDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment newFragment1 = new DatePickerFragment();
                newFragment1.show(getSupportFragmentManager(), DATE_DIALOG);
            }
        });
        //----------------------------------------------------------DATE PICKER
    }
}