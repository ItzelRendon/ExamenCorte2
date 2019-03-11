package com.example.itzel.examencorte2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void encuesta(View view){
        try {
            Intent ventanaFinal = new Intent(this, Pregunta1.class);
            startActivity(ventanaFinal);
            finish();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void resultados(View view){
        try {
            Intent ventanaFinal = new Intent(this, Resultado.class);
            startActivity(ventanaFinal);
            finish();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
