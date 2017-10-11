package com.example.katherine.gamemultiplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private EditText resul;
    private TextView dato1, dato2, puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resul = (EditText)findViewById(R.id.resultado);
        dato1 = (TextView)findViewById(R.id.dato1);
        dato2 = (TextView)findViewById(R.id.dato2);
        puntaje = (TextView)findViewById(R.id.puntaje);
    }

    public void restart (){
        int pnt = 0;
        String p = String.valueOf(pnt);
        puntaje.setText(p);
    }

    public  void  numeros (){
        int ran1 = (int) (Math.random()*12+1);
        int ran2 = (int) (Math.random()*12+1);
        String r1 = String.valueOf(ran1);
        String r2 = String.valueOf(ran2);
        dato1.setText(r1);
        dato2.setText(r2);
    }

    public void iniciar(View view){
        restart();
        numeros();
    }

    public void multiplicar(View view){

        if(     dato1.getText().toString().equals("") ||
                dato2.getText().toString().equals("") )

        {
            Toast iniciar = Toast.makeText(this,"Presione INICIAR",Toast.LENGTH_SHORT);
            iniciar.show();
            return;
        }

        if(resul.getText().toString().equals("")){
            Toast salir = Toast.makeText(this,"Ingrese el resultado",Toast.LENGTH_SHORT);
            salir.show();
            return;

        }

        String pun = puntaje.getText().toString();
        int pnt=Integer.parseInt(pun);

        if ( pnt >= 0 && pnt < 5 ){

            String valor1 = dato1.getText().toString();
            String valor2 = dato2.getText().toString();
            int nro1=Integer.parseInt(valor1);
            int nro2=Integer.parseInt(valor2);

            String igual = resul.getText().toString();
            int r_user = Integer.parseInt(igual);
            int res = nro1 * nro2;

            if (r_user == res){
                pnt = pnt + 1;
                String p = String.valueOf(pnt);
                puntaje.setText(p);
                Toast correcto = Toast.makeText(this,"Correcto",Toast.LENGTH_SHORT);
                correcto.show();
                if(pnt < 5){
                    numeros();
                    resul.setText("");
                }
                else {
                    Toast fin = Toast.makeText(this,getResources().getString(R.string.ganar),Toast.LENGTH_LONG);
                    fin.show();
                    MediaPlayer mp = MediaPlayer.create(this, R.raw.aplauso);
                    mp.start();
                    dato1.setText("");
                    dato2.setText("");
                    resul.setText("");
                }
            }

            else{
                Toast equivocado = Toast.makeText(this,getResources().getString(R.string.perder),Toast.LENGTH_SHORT);
                equivocado.show();
            }

        }
    }

    public void about(View view){
        Intent i = new Intent(this,AboutActivity.class);
        startActivity(i);
    }
}
