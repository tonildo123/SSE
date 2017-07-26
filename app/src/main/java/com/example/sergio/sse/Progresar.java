package com.example.sergio.sse;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Progresar extends AppCompatActivity {
    Button bv, bcp, brp;
    LinearLayout cp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progresar);

        bv = (Button)findViewById(R.id.button2);
        bcp = (Button)findViewById(R.id.bCroPro);
        brp= (Button)findViewById(R.id.bReqPro);
        cp = (LinearLayout)findViewById(R.id.contenedorProgresar);

        RequisitosPro rp = new RequisitosPro();
        FragmentManager m = getSupportFragmentManager();
        m.beginTransaction().replace(R.id.contenedorProgresar, rp).commit();

        brp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequisitosPro rp = new RequisitosPro();
                FragmentManager m = getSupportFragmentManager();
                m.beginTransaction().replace(R.id.contenedorProgresar, rp).commit();

            }
        });
        bcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConsultaProgresar cp = new ConsultaProgresar();
                FragmentManager m = getSupportFragmentManager();
                m.beginTransaction().replace(R.id.contenedorProgresar, cp).commit();

            }
        });






        bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Progresar.this, MainActivity.class);
                startActivity(volver);
            }
        });


    }
}
