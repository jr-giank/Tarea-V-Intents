package com.example.tareav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Frases extends AppCompatActivity {

    Button atras, salir;
    TextView nombre, frase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        atras = findViewById(R.id.atras);
        salir = findViewById(R.id.salir);
        nombre = findViewById(R.id.nombre);
        frase = findViewById(R.id.frase);

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
                AlertDialog.Builder builder = new AlertDialog.Builder(Frases.this);
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
            frasesHombre();
        }else if(userGenero.equals("mujer")){
            frasesMujer();
        }
    }

    public void Atras(){
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void frasesHombre(){
        Random random = new Random();
        int numero = random.nextInt(5)+1;

        if(numero == 1){
            frase.setText("En la vida algunas veces se gana, otras veces se aprende (John Maxwell)");
        }else if(numero == 2){
            frase.setText("No midas tu riqueza por el dinero que tienes, mídela por aquellas cosas que tienes y que no cambiarías por dinero (Paulo Coelho)");
        }else if(numero == 3){
            frase.setText("Pedir perdón es de inteligentes, perdonar es de nobles y perdonarse es de sabios (Anónimo)");
        }else if(numero == 4){
            frase.setText("El que busca un amigo sin defectos se queda sin amigos (Proverbio turco)");
        }else if(numero == 5){
            frase.setText("No encuentres la falta, encuentra el remedio (Henry Ford)");
        }
    }

    public void frasesMujer(){
        Random random = new Random();
        int numero = random.nextInt(5)+1;

        if(numero == 1){
            frase.setText("No podemos dejar que las percepciones limitadas de los demás terminen definiéndonos (Virginia Satir)");
        }else if(numero == 2){
            frase.setText("Si se quiere viajar lejos, no hay mejor nave que un libro (Emily Dickinson)");
        }else if(numero == 3){
            frase.setText("La mejor vida no es la más duradera, sino la más bien aquella que está repleta de buenas acciones (Marie Curie)");
        }else if(numero == 4){
            frase.setText("No nacemos como mujer, sino que nos convertimos en una (Simone de Beauvoir)");
        }else if(numero == 5){
            frase.setText("Quienes no se mueven no notan sus cadenas (Rosa Luxemburgo)");
        }
    }
}