package com.example.sergio.sse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bienvenida extends AppCompatActivity {

 int tiempo_de_espera = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

    Thread hilo2 = new Thread(){

        @Override
        public void run() {
            try {
                sleep(tiempo_de_espera);
                Intent pasar = new Intent(Bienvenida.this, MainActivity.class );
                startActivity(pasar);
                finish();

            }catch (Exception ex){

                ex.printStackTrace();
            }
        }
    };

    hilo2.start();


    }
}
