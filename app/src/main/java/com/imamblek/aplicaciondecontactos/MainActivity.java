package com.imamblek.aplicaciondecontactos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.imamblek.aplicaciondecontactos.DatePickerFragment.DATE_DIALOG;
import static com.imamblek.aplicaciondecontactos.DatePickerFragment.txtDate;



public class MainActivity extends AppCompatActivity  {
///Declaracion de variables
    EditText etnombre;
    EditText etfechaNacimientoPicker;
    EditText ettelefono;
    EditText etemail;
    EditText etdescripcion;


    private Button botonSalvar;

    String NOMBRE;
    String FECHA;
    String TELEFONO;
    String EMAIL;
    String DESCRIPCION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);

        etnombre = findViewById(R.id.etnombre);
        etfechaNacimientoPicker =  findViewById(R.id.etfechaNacimientoPicker);
        ettelefono =  findViewById(R.id.ettelefono);
        etemail =  findViewById(R.id.etemail);
        etdescripcion =  findViewById(R.id.etdescripcionContacto);
        //----------------------------------------------------------
        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
           // Toast.makeText(getApplicationContext(), "savedInstanceState != null", Toast.LENGTH_LONG).show();
            NOMBRE = savedInstanceState.getString("NOMBRE_KEY");
            FECHA = savedInstanceState.getString("FECHA_KEY");
            TELEFONO = savedInstanceState.getString("TELEFONO_KEY");
            EMAIL = savedInstanceState.getString("EMAIL_KEY");
            DESCRIPCION = savedInstanceState.getString("DESCRIPCION_KEY");
            String message = savedInstanceState.getString("message");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        } else {
            // Probably initialize members with default values for a new instance
            //Toast.makeText(getApplicationContext(), "savedInstanceState == null", Toast.LENGTH_LONG).show();
        }


        //----------------------------------------------------------

        botonSalvar = findViewById(R.id.botonSalvarDatosUsuario);
        botonSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent mostrarPantallaDetalles = new Intent(MainActivity.this, DetalleContacto.class);
                mostrarPantallaDetalles.putExtra("$nombre", etnombre.getText().toString());
                mostrarPantallaDetalles.putExtra("$fecha", etfechaNacimientoPicker.getText().toString());
                mostrarPantallaDetalles.putExtra("$telefono", ettelefono.getText().toString());
                mostrarPantallaDetalles.putExtra("$email", etemail.getText().toString());
                mostrarPantallaDetalles.putExtra("$descripcion", etdescripcion.getText().toString());
                startActivity(mostrarPantallaDetalles);

            }
        });

        //----------------------------------------------------------
        //----------------------------------------------------------DATE PICKER 1
        txtDate = findViewById(R.id.etfechaNacimientoPicker);
        txtDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment newFragment1 = new DatePickerFragment();
                newFragment1.show(getSupportFragmentManager(), DATE_DIALOG);
            }
        });
        //----------------------------------------------------------DATE PICKER 1
    }

    @Override
    protected void onResume() {
        super.onResume();
       // Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_LONG).show();

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
       // Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_LONG).show();
        // Save the user's current data state
        outState.putString("NOMBRE_KEY", etnombre.getText().toString());
        outState.putString("FECHA_KEY", etfechaNacimientoPicker.getText().toString());
        outState.putString("TELEFONO_KEY", ettelefono.getText().toString());
        outState.putString("EMAIL_KEY", etemail.getText().toString());
        outState.putString("DESCRIPCION_KEY", etdescripcion.getText().toString());
        outState.putString("message", "This is my message to be reloaded");

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onRestoreInstanceState(Bundle outState) {
      //  Toast.makeText(getApplicationContext(), "onRestoreInstanceState", Toast.LENGTH_LONG).show();
        etnombre.setText(outState.getString("NOMBRE_KEY"));
        etfechaNacimientoPicker.setText(outState.getString("FECHA_KEY"));
        ettelefono.setText(outState.getString("TELEFONO_KEY"));
        etemail.setText(outState.getString("EMAIL_KEY"));
        etdescripcion.setText(outState.getString("DESCRIPCION_KEY"));

        super.onRestoreInstanceState(outState);
    }


    public EditText getEtnombre() {

        return etnombre;
    }

    public void setEtnombre(EditText etnombre) {

        this.etnombre = etnombre;
    }

    public EditText getEtfecha() {
        return etfechaNacimientoPicker;
    }

    public void setEtfechaNacimientoPicker(EditText etfechaNacimientoPicker) {
        this.etfechaNacimientoPicker = etfechaNacimientoPicker;
    }

    public EditText getEttelefono() {
        return ettelefono;
    }

    public void setEttelefono(EditText ettelefono) {
        this.ettelefono = ettelefono;
    }

    public EditText getEtemail() {
        return etemail;
    }

    public void setEtemail(EditText etemail) {
        this.etemail = etemail;
    }

    public EditText getEtdescripcion() {
        return etdescripcion;
    }

    public void setEtdescripcion(EditText etdescripcion) {
        this.etdescripcion = etdescripcion;
    }
}