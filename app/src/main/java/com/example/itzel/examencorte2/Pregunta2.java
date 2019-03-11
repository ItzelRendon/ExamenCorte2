package com.example.itzel.examencorte2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Pregunta2 extends AppCompatActivity {
    private RadioButton opc1;
    private RadioButton opc2;
    private RadioButton opc3;
    private RadioButton opc4;

    String pregunta1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);

        opc1 = (RadioButton) findViewById(R.id.opc1);
        opc2 = (RadioButton) findViewById(R.id.opc2);
        opc3 = (RadioButton) findViewById(R.id.opc3);
        opc4 = (RadioButton) findViewById(R.id.opc4);

        try {
            Bundle bundle = getIntent().getExtras();
            pregunta1 = bundle.getString("pregunta1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sig(View v)
    {
        try {
            int opcion = 0;
            if(opc1.isChecked())
                opcion = 1;
            else if(opc2.isChecked())
                opcion = 2;
            else if(opc3.isChecked())
                opcion = 3;
            else if(opc4.isChecked())
                opcion = 4;
            if(opcion == 0) {
                Toast.makeText(this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
            }else {
                Intent ventana = new Intent(this, Pregunta3.class);
                ventana.putExtra("pregunta1", pregunta1);
                ventana.putExtra("pregunta2", ""+opcion);
                startActivity(ventana);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
