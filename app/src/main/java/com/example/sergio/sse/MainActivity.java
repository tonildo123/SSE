package com.example.sergio.sse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    ImageView imagen;
    String urlImegn="http://i.imgur.com/DvpvklR.png";
    private String title;
    private String titleid;
    private TextView tit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Crear un nuevo hilo, ya que el hilo principal no permite que se realicen tareas largas o con acceso a internet.
        new Thread(new Runnable() {
            public void run() {
                //En esta sección realizar todo el trabajo pesado, ya que es el comienzo de un nuevo hilo creado
                Document doc;
                try {
                    //necesitará protocolo http
                    //doc trae el html completo de la url que se le agregue
                    doc = Jsoup.connect("http://http://181.14.240.59/Portal/").userAgent("Mozilla").get();
                    //La función title() lo que hace es buscar el atributo <title> y lo trae en forma de string.
                    title = doc.title();
                    //Utilizar Element para buscar un elemento en especial, en este caso el id hplogo que se encuentra dentro de un <div>.
                    Element slider = doc.select("div[id=home-slider]").first();
                    //Buscamos el atributo style y lo convertimos a string, el atributo style utiliza el Element image
                    titleid=slider.select("a");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Mostrar los resultados.
                runOnUiThread(new Runnable() {
                    public void run() {
                        //Como ya se vincularon los componentes, se podrá utilizar sin problemas.
                        //En esta parte siempre mostrar los resultados.
                        for (Element link : articulos3) {
                            // imprimirlos
                            System.out.println("link : " + link.attr("href"));
                            System.out.println("titulo : " + link.attr("title"));
                        }
                        tit.setText(title);
                        text.setText(titleid);
                        Toast.makeText(MainActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
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
