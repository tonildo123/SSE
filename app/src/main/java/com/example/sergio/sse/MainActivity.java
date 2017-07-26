package com.example.sergio.sse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    ImageView imagen;
    String urlImegn="http://i.imgur.com/DvpvklR.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen =(ImageView)findViewById(R.id.imagenNoticias);
        Picasso.with(getApplication()).load(urlImegn).fit().into(imagen);


        b1 = (Button)findViewById(R.id.bJovenes);
        b2 = (Button)findViewById(R.id.bProgresar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pasar = new Intent(MainActivity.this, Jovenes.class);
                startActivity(pasar);
            }
        });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent pasar = new Intent(MainActivity.this, Progresar.class);
            startActivity(pasar);
        }
    });




    }
}
