package com.example.itzel.examencorte2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Resultado extends AppCompatActivity {
    private TextView respuesta;
    private TextView pre_txt1;
    private TextView pre2_txt1;
    private TextView pre3_txt1;
    private TextView pre4_txt1;
    private TextView pre5_txt1;

    int tamanio = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        respuesta = (TextView) findViewById(R.id.txtPersonas);
        pre_txt1 = (TextView) findViewById(R.id.pre_txt1);
        pre2_txt1 = (TextView) findViewById(R.id.pre2_txt1);
        pre3_txt1 = (TextView) findViewById(R.id.pre3_txt1);
        pre4_txt1 = (TextView) findViewById(R.id.pre4_txt1);
        pre5_txt1 = (TextView) findViewById(R.id.pre5_txt1);

        try {
            // respuesta.setText(""+pregunta1+"-"+pregunta2+"-"+pregunta3+"-"+pregunta4+"-"+pregunta5);

            AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            Cursor fila = bd.rawQuery("select * from preguntas", null);
            tamanio = fila.getCount();
            respuesta.setText("Número de personas encuestadas: " + tamanio);
            if(tamanio>0) {
                int numero_de_preguntas = 5;
                Cursor[] pre1 = new Cursor[numero_de_preguntas];
                Cursor[] pre2 = new Cursor[numero_de_preguntas];
                Cursor[] pre3 = new Cursor[numero_de_preguntas];
                Cursor[] pre4 = new Cursor[numero_de_preguntas];


                for (int x = 0; x < numero_de_preguntas; x++) {
                    pre1[x] = bd.rawQuery("select * from preguntas where pregunta" + (x + 1) + "= 1", null);
                    pre2[x] = bd.rawQuery("select * from preguntas where pregunta" + (x + 1) + "= 2", null);
                    pre3[x] = bd.rawQuery("select * from preguntas where pregunta" + (x + 1) + "= 3", null);
                    pre4[x] = bd.rawQuery("select * from preguntas where pregunta" + (x + 1) + "= 4", null);
                }


                pre_txt1.setText("1 vez al mes - " + porcentaje(pre1[0].getCount()) + "%\n" +
                        "1 vez cada semana - " + porcentaje(pre2[0].getCount()) + "%\n" +
                        "Más de una vez a la semana - " + porcentaje(pre3[0].getCount()) + "%\n" +
                        "Casi nunca - " + porcentaje(pre4[0].getCount()) + "%");

                pre2_txt1.setText("Malo - " + porcentaje(pre1[1].getCount()) + "%\n" +
                        "Regular - " + porcentaje(pre2[1].getCount()) + "%\n" +
                        "Bueno - " + porcentaje(pre3[1].getCount()) + "%\n" +
                        "Excelente - " + porcentaje(pre4[1].getCount()) + "%");

                pre3_txt1.setText("Malo - " + porcentaje(pre1[2].getCount()) + "%\n" +
                        "Regular - " + porcentaje(pre2[2].getCount()) + "%\n" +
                        "Bueno - " + porcentaje(pre3[2].getCount()) + "%\n" +
                        "Excelente - " + porcentaje(pre4[2].getCount()) + "%");

                pre4_txt1.setText("Malo - " + porcentaje(pre1[3].getCount()) + "%\n" +
                        "Regular - " + porcentaje(pre2[3].getCount()) + "%\n" +
                        "Bueno - " + porcentaje(pre3[3].getCount()) + "%\n" +
                        "Excelente - " + porcentaje(pre4[3].getCount()) + "%");

                pre5_txt1.setText("3D - " + porcentaje(pre1[4].getCount()) + "%\n" +
                        "Sala normal - " + porcentaje(pre2[4].getCount()) + "%\n" +
                        "Macro XE - " + porcentaje(pre3[4].getCount()) + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int porcentaje(int valor)
    {
        return (valor * 100)/tamanio;
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
