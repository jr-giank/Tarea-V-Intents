package com.example.tareav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class Imagenes extends AppCompatActivity {

    Button atras, salir;
    TextView nombre;
    ImageView imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        atras = findViewById(R.id.atras);
        salir = findViewById(R.id.salir);
        nombre = findViewById(R.id.nombre);
        imagenes = findViewById(R.id.imagenes);

        String userName = getIntent().getStringExtra("keyNombre");
        String userGenero = getIntent().getStringExtra("keyGenero");

        nombre.setText(userName);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atras();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Imagenes.this);
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

        if(userGenero.equals("hombre")){
            imagenesHombre();
        }else if(userGenero.equals("mujer")){
            imagenesMujer();
        }
    }

    public void Atras(){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void imagenesHombre(){
        Random random = new Random();
        int numero = random.nextInt(5)+1;

        if(numero == 1){
            imagenes.setImageResource(R.drawable.hombre1);
        }else if(numero == 2){
            imagenes.setImageResource(R.drawable.hombre2);
        }else if(numero == 3){
            imagenes.setImageResource(R.drawable.hombre3);
        }else if(numero == 4){
            imagenes.setImageResource(R.drawable.hombre4);
        }else if(numero == 5){
            imagenes.setImageResource(R.drawable.hombre5);
        }
    }

    public void imagenesMujer(){
        Random random = new Random();
        int numero = random.nextInt(5)+1;

        if(numero == 1){
            imagenes.setImageResource(R.drawable.mujer1);
        }else if(numero == 2){
            imagenes.setImageResource(R.drawable.mujer2);
        }else if(numero == 3){
            imagenes.setImageResource(R.drawable.mujer3);
        }else if(numero == 4){
            imagenes.setImageResource(R.drawable.mujer4);
        }else if(numero == 5){
            imagenes.setImageResource(R.drawable.mujer5);
        }
    }
}