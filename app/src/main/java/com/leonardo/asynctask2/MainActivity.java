package com.leonardo.asynctask2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.AsynchronousChannelGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button boton1, boton2;
    private TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = findViewById(R.id.boton1);
        boton2 = findViewById(R.id.prueba);
        txt1 = findViewById(R.id.texto1);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton1:

                ////OTRA FORMA
                MiTarea miTarea = new MiTarea(txt1);
                miTarea.execute();
                Toast.makeText(MainActivity.this,"Asynctask en otra clase", Toast.LENGTH_LONG).show();

                /*/////////OTRA FORMA
                Tarea tarea1 = new Tarea();
                tarea1.execute();*/
                break;
            case R.id.prueba:
                System.out.println("-------BOTON PRUEBA");
                Toast.makeText(this,"Boton prueba",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
    private class Tarea extends AsyncTask<Void,Integer, String>{
        @Override
        protected void onPreExecute() {
            txt1.setText("0");
        }
        @Override
        protected String doInBackground(Void... voids) {
            for(int i=1; i<=5 ; i++){
                esperarUnSegundo();
                publishProgress(i);
            }
            return "Finalizado";
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            txt1.setText(values[0].toString());
        }
        @Override
        protected void onPostExecute(String s) {
            txt1.setText(s);
        }
    }
    private void esperarUnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}