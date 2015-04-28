package com.example.root.bilangankompleks;
/**
 * Creat by Fahzul
 */


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClickBtnHitung(View view){
        float real1;
        float real2;
        float imj1;
        float imj2;

        int noinput= 0;

        EditText editTextreal1 = (EditText) findViewById(R.id.txt_real);
        if(editTextreal1.length()==noinput){
            real1=0;
            editTextreal1.setText("0");
        }else {
            real1 = Float.valueOf(String.valueOf(editTextreal1.getText()));
        }

        EditText editTextreal2 = (EditText) findViewById(R.id.txt_real2);
        if(editTextreal2.length()==noinput){
            real2=0;
            editTextreal2.setText("0");
        }else{
            real2 = Float.valueOf(String.valueOf(editTextreal2.getText()));
        }

        EditText editTextimag1 = (EditText) findViewById(R.id.txt_imj);
        if(editTextimag1.length()==noinput){
            imj1=0;
            editTextimag1.setText("0");
        }else{
            imj1 = Float.valueOf(String.valueOf(editTextimag1.getText()));
        }

        EditText editTextimag2 = (EditText) findViewById(R.id.txt_imj2);
        if(editTextimag2.length()==noinput){
            imj2= 0;
            editTextimag2.setText("0");
        }else{
            imj2 = Float.valueOf(String.valueOf(editTextimag2.getText()));
        }

        Spinner spinner_operator = (Spinner) findViewById(R.id.sel_operator);

        float hasil_real=0;
        float hasil_imj=0;

        String salahOper = "";
        if (spinner_operator.getSelectedItem().equals("+")){
            hasil_real = real1 + real2;
            hasil_imj = imj1 + imj2;
        }else if (spinner_operator.getSelectedItem().equals("-")){
            hasil_real = real1 - real2;
            hasil_imj = imj1 - imj2;
        }else if (spinner_operator.getSelectedItem().equals("*")){
            hasil_real = real1 * real2;
            hasil_imj = imj1 * imj2;
        }else if (spinner_operator.getSelectedItem().equals("/")){
            hasil_real = real1 / real2;
            hasil_imj = imj1 / imj2;
        }else{
            salahOper = "Kesalahan Operasi!";
        }

        String hasil_realStr = String.valueOf(hasil_real);
        String hasil_imagStr = String.valueOf(hasil_imj);

        //check apakah bil. memiliki desimal
        if(hasil_realStr.endsWith(".0") && hasil_imagStr.endsWith(".0")){
            //hapus desimal
            int hasil_realInt = Math.round(Float.valueOf(hasil_realStr));
            int hasil_imagInt = Math.round(Float.valueOf(hasil_imagStr));

            hasil_realStr = String.valueOf(hasil_realInt);
            hasil_imagStr = String.valueOf(hasil_imagInt);
        }else if(hasil_realStr.endsWith(".0")){
            //hapus desimal
            int hasil_realInt = Math.round(Float.valueOf(hasil_realStr));

            hasil_realStr = String.valueOf(hasil_realInt);
        }else if(hasil_imagStr.endsWith(".0")){
            //hapus desimal
            int hasil_imagInt = Math.round(Float.valueOf(hasil_imagStr));

            hasil_imagStr = String.valueOf(hasil_imagInt);
        }
        TextView textView = (TextView) findViewById(R.id.txt_hasil);

        if(salahOper.length()>0){
            textView.setText(salahOper);
        }else if(hasil_imagStr.contains("-")){
            //cek untuk bil. imj negatif
            hasil_imj = Math.abs(Float.valueOf(hasil_imagStr));
            hasil_imagStr = String.valueOf(hasil_imj);

            //cek untuk bil. desiaml
            if (hasil_imagStr.endsWith(".0")){
                int hasil_imagInt = Math.round(Float.valueOf(hasil_imagStr));
                hasil_imagStr = String.valueOf(hasil_imagInt);
            }

            textView.setText("Result = "+hasil_realStr+"- j"+hasil_imagStr);

        }else{
            textView.setText("Result = "+hasil_realStr+"+ j"+hasil_imagStr);
        }
    }
}
