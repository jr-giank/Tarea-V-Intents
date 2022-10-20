package com.example.tareav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Principal extends AppCompatActivity {

    Button imagenes, frases, salir;
    RadioButton hombre, mujer;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imagenes = findViewById(R.id.imagenes);
        frases = findViewById(R.id.frases);
        salir = findViewById(R.id.salir);

        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);

        nombre = findViewById(R.id.nombre);

        imagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagenesLayout();
            }
        });

        frases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrasesLayout();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Principal.this);
                builder.setMessage("¿Seguro que quieres salir?")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void ImagenesLayout(){
        String stringNombre = nombre.getText().toString();
        String genero = "";

        if(hombre.isChecked()){
            genero = "hombre";
        }else if(mujer.isChecked()){
            genero = "mujer";
        }

        Intent intent = new Intent(this, Imagenes.class);
        intent.putExtra("keyNombre", stringNombre);
        intent.putExtra("keyGenero", genero);
        startActivity(intent);
    }

    public void FrasesLayout(){
        String stringNombre = nombre.getText().toString();
        String genero = "";

        if(hombre.isChecked()){
            genero = "hombre";
        }else if(mujer.isChecked()){
            genero = "mujer";
        }

        Intent intent = new Intent(this, Frases.class);
        intent.putExtra("keyNombre", stringNombre);
        intent.putExtra("keyGenero", genero);
        startActivity(intent);
    }
}