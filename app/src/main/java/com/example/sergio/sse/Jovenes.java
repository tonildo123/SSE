package com.example.sergio.sse;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Jovenes extends AppCompatActivity {

    Button bv, br, bc;
    LinearLayout c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jovenes);

        bv = (Button)findViewById(R.id.bVolverJoven);
        br = (Button)findViewById(R.id.bReqJoven);
        bc = (Button)findViewById(R.id.bCronoJoven);

        c = (LinearLayout)findViewById(R.id.contenendorJoven);

        RequisitosJoven rj = new RequisitosJoven();
        FragmentManager m = getSupportFragmentManager();
        m.beginTransaction().replace(R.id.contenendorJoven, rj).commit();

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequisitosJoven rj = new RequisitosJoven();
                FragmentManager m = getSupportFragmentManager();
                m.beginTransaction().replace(R.id.contenendorJoven, rj).commit();
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CronogramaJoven cj = new CronogramaJoven();
                FragmentManager m = getSupportFragmentManager();
                m.beginTransaction().replace(R.id.contenendorJoven, cj).commit();
            }
        });

        bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Jovenes.this, MainActivity.class);
                startActivity(volver);
            }
        });



    }
}
