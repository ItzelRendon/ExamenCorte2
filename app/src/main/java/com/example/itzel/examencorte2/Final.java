package com.example.itzel.examencorte2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
    }

    public void salir(View view){
        try {
            Intent ventanaFinal = new Intent(this, MainActivity.class);
            startActivity(ventanaFinal);
            finish();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
