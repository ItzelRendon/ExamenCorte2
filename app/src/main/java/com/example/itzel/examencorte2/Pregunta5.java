package com.example.itzel.examencorte2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Pregunta5 extends AppCompatActivity {
    private RadioButton opc1;
    private RadioButton opc2;
    private RadioButton opc3;

    String pregunta1;
    String pregunta2;
    String pregunta3;
    String pregunta4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta5);
        opc1 = (RadioButton) findViewById(R.id.opc1);
        opc2 = (RadioButton) findViewById(R.id.opc2);
        opc3 = (RadioButton) findViewById(R.id.opc3);

        try {
            Bundle bundle = getIntent().getExtras();
            pregunta1 = bundle.getString("pregunta1");
            pregunta2 = bundle.getString("pregunta2");
            pregunta3 = bundle.getString("pregunta3");
            pregunta4 = bundle.getString("pregunta4");
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
            if(opcion == 0) {
                Toast.makeText(this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
            }else {
                AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
                SQLiteDatabase bd = admin.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("pregunta1", pregunta1);
                registro.put("pregunta2", pregunta2);
                registro.put("pregunta3", pregunta3);
                registro.put("pregunta4", pregunta4);
                registro.put("pregunta5", ""+opcion);
                bd.insert("preguntas", null, registro);
                bd.close();
                Intent ventanaFinal = new Intent(this, Final.class);
                startActivity(ventanaFinal);
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
