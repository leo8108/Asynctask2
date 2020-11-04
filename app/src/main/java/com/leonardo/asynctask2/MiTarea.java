package com.leonardo.asynctask2;
import android.os.AsyncTask;
import android.widget.TextView;

public class MiTarea extends AsyncTask<Void,Integer, String> {

    TextView txt1;
    MiTarea(TextView txt1) {
        this.txt1 = txt1;
    }
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
    private void esperarUnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
